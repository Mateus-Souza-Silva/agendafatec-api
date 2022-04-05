package br.com.projetoagendafatec.agendafatecapi;

import br.com.projetoagendafatec.agendafatecapi.model.entity.Contato;
import br.com.projetoagendafatec.agendafatecapi.model.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendafatecApiApplication {

	/*@Bean
	public CommandLineRunner nun(@Autowired ContatoRepository repository) {
		return args -> {
			Contato contato = new Contato();
			contato.setNome("Mateus");
			contato.setEmail("tiago@teste.com");
			contato.setFavorito(false);
			repository.save(contato);
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(AgendafatecApiApplication.class, args);
	}

}
