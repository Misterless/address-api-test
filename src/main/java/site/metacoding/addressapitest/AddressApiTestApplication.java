package site.metacoding.addressapitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AddressApiTestApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AddressApiTestApplication.class, args);
	}

}
