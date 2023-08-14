package br.com.olatcg_backend;

import br.com.olatcg_backend.domain.homology.search.ResourceOlatcgHomology;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAsync
public class OlatcgBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlatcgBackendApplication.class, args);
	}

	@PostConstruct
	void init(){
		new ResourceOlatcgHomology();
	}
}
