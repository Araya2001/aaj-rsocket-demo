package aaj.rsocketdemo.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface PingHandler {
  Mono<ServerResponse> getPing(ServerRequest request);
}
