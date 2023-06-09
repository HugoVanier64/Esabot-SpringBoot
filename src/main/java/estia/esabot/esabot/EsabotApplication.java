package estia.esabot.esabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "{estia.esabot.esabot.controllers}")
public class EsabotApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsabotApplication.class, args);
	}

}
