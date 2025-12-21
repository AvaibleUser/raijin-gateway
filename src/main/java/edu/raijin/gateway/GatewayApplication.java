package edu.raijin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "edu.raijin")
@ConfigurationPropertiesScan(basePackages = "edu.raijin")
@PropertySource(value = "file:${user.dir}/.env", ignoreResourceNotFound = true)
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
