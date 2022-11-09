package aaj.rsocketdemo.router;

import aaj.rsocketdemo.handler.PingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration(proxyBeanMethods = false)
public class PingRouter {
  @Bean
  public RouterFunction<ServerResponse> routePing(PingHandler pingHandler) {
    return RouterFunctions.route(GET("/ping"), pingHandler::getPing);
  }
}
