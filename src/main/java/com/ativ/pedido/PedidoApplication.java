package com.ativ.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//exclui a critografia (exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

// @SpringBootApplication
public class PedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}

}
