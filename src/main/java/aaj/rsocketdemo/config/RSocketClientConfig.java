package aaj.rsocketdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.util.MimeTypeUtils;
import reactor.util.retry.Retry;

import java.time.Duration;

@Configuration
public class RSocketClientConfig {
  @Bean
  public RSocketRequester getRSocketRequester(){
    RSocketRequester.Builder builder = RSocketRequester.builder();

    return builder
        .rsocketConnector(
            rSocketConnector ->
                rSocketConnector.reconnect(Retry.fixedDelay(2, Duration.ofSeconds(2)))
        )
        .dataMimeType(MimeTypeUtils.APPLICATION_JSON)
        .tcp("localhost", 7000);
  }
}
