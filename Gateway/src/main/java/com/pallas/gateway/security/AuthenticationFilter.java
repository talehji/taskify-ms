package com.pallas.gateway.security;

import com.pallas.gateway.exceptions.AuthenticationErrorException;
import com.pallas.gateway.models.ResponseErrorDTO;
import com.pallas.gateway.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.*;


@RefreshScope
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final RouterValidator routerValidator;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public AuthenticationFilter(RouterValidator routerValidator, WebClient.Builder webClientBuilder) {
        super(Config.class);
        this.routerValidator = routerValidator;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (routerValidator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new AuthenticationErrorException(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED");
                }

                String authHeader = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
                try {
                    return webClientBuilder.build()
                            .get()
                            .uri("http://organisation-service/organisation/api/v1/user/validate")
                            .header(HttpHeaders.AUTHORIZATION, authHeader)
                            .retrieve()
                            .onStatus(
                                    httpStatus -> httpStatus.value() == 403,
                                    response -> response.bodyToMono(String.class)
                                            .map(s-> new AuthenticationErrorException(
                                                    HttpStatus.UNAUTHORIZED,
                                                    "UNAUTHORIZED"
                                            )))
                            .bodyToMono(User.class)
                            .map(user -> {
                                //not used. Demo purpose only
                                exchange.getRequest().mutate().header("user-id", user != null ? "" + user.getId() :null);
                                return exchange;
                            })
                            .flatMap(chain::filter);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    List<String> details = new ArrayList<>();
                    details.add(ex.getLocalizedMessage());
                    ResponseErrorDTO error = new ResponseErrorDTO();
                    error.setMessage("Authentication error");
                    ServerHttpResponse response = exchange.getResponse();

                    byte[] bytes = SerializationUtils.serialize(error);

                    DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                    response.writeWith(Flux.just(buffer));
                    response.setStatusCode(HttpStatus.UNAUTHORIZED);
                    return response.setComplete();
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {
    }
}