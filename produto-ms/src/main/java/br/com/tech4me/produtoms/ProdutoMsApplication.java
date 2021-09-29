package br.com.tech4me.produtoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProdutoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoMsApplication.class, args);
	}

}
