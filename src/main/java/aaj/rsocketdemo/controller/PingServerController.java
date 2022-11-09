package aaj.rsocketdemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class PingServerController {
  @MessageMapping("ping")
  public Flux<String> feedPing() {
    return Flux.just("ping1", "ping2", "ping3");
  }
}
