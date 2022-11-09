package aaj.rsocketdemo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PingHandlerImpl implements PingHandler {
  private final RSocketRequester rSocketRequester;

  @Autowired
  public PingHandlerImpl(RSocketRequester rSocketRequester) {
    this.rSocketRequester = rSocketRequester;
  }

  @Override
  public Mono<ServerResponse> getPing(ServerRequest request) {
    Flux<String> ping = rSocketRequester
        .route("ping")
        .retrieveFlux(String.class);
    return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(ping, String.class);
  }
}
