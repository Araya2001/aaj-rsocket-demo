package aaj.rsocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@PropertySource("classpath:dev.properties")
@EnableAsync
public class AajRsocketDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AajRsocketDemoApplication.class, args);
	}

}
