package br.com.primesoftware.screenmatch;

import br.com.primesoftware.screenmatch.model.DadosSerie;
import br.com.primesoftware.screenmatch.service.ConsumoAPI;
import br.com.primesoftware.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=fd010253");
		System.out.println(json);
	//	json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
	//	System.out.println(json);

		var converteDADOS = new ConverteDados();

		DadosSerie dadosSerie = converteDADOS.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);

	}
}
