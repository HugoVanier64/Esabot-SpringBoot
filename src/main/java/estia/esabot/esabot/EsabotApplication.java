package estia.esabot.esabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan

@SpringBootApplication
public class EsabotApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsabotApplication.class, args);
	}

}
