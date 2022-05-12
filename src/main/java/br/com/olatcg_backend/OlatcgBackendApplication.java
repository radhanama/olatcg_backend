package br.com.olatcg_backend;

import br.com.olatcg_backend.data.IUserData;
import br.com.olatcg_backend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAsync
public class OlatcgBackendApplication {

	@Autowired
	private IUserData userRepository;

	@PostConstruct
	private void init(){
		if(userRepository.findByName("admin") == null){
			userRepository.save(new User("admin", "admin@admin.com", "123Mudar"));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(OlatcgBackendApplication.class, args);
	}
}
