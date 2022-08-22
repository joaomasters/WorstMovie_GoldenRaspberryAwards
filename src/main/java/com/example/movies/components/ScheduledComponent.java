package com.example.movies.components;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.movies.dto.MoviesDTO;
import com.example.movies.model.Movies;
import com.example.movies.model.Producers;
import com.example.movies.model.Studios;
import com.example.movies.service.MoviesService;
import com.example.movies.service.ProducersService;
import com.example.movies.service.StudiosService;

@Component
@EnableScheduling
public class ScheduledComponent {
	
	public static final String URL = "src/main/resources/csv/movielist.csv";
	
	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private ProducersService producersService;
	
	@Autowired
	private StudiosService studiosService;
	
	private List<Studios> studiosArray;
	
	private List<Producers> producersArray;
	
	@Scheduled(cron="30 * * * * *")
	public void execute() {
		try {
			processarArquivoCsv(new FileReader(URL));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void processarArquivoCsv(FileReader fileReader) {
		System.out.println("Iniciando leitura do arquivo...");
		try (BufferedReader br = new BufferedReader(fileReader)) {
			String line;
			int contador = 0;
			do {
				line = br.readLine();
				if(line != null & contador == 0) {
					line = line.replace(" ", "");
				    String[] values = line.split(";");
				    this.processarDados(values);
				}else {
					contador++;
				}				
			} while (line != null);
			br.close();	
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void processarDados(String[] values) {

		MoviesDTO moviesDTO = new MoviesDTO();
		moviesDTO.setYear(values[0]);
		moviesDTO.setTitle(values[1]);

		if (values.length > 2) {
			String[] strStudiosArray = values[2].split(",");
			studiosArray = new ArrayList<Studios>();
			for (String str : strStudiosArray) {
				Studios studios = new Studios();
				studios.setName(str);	
				studios.setMovies(null);
				studiosArray.add(studios);
			}
		}

		if (values.length > 3) {
			String[] strProducersArray = values[3].split(",");
			producersArray = new ArrayList<Producers>();
			for (String str : strProducersArray) {
				Producers producers = new Producers();
				producers.setName(str);
				producers.setMovies(null);
				producersArray.add(producers);
			}
		}

		if (values.length > 4) {
			moviesDTO.setWinner(values[4]);
		}
		
		Movies movies = new Movies();
		movies.setYear(moviesDTO.getYear());
		movies.setTitle(moviesDTO.getTitle());
		movies.setStudios(null);
		movies.setProducers(null);
		movies.setWinner(moviesDTO.getWinner());
				
		movies = moviesService.save(movies); 	
		
		for (Studios studios : studiosArray) {
			studios.setMovies(movies);
			studios = studiosService.save(studios);
		}
		
		for (Producers producers : producersArray) {
			producers.setMovies(movies);
			producers = producersService.save(producers);
		}
		
		movies.setStudios(studiosArray);
		movies.setProducers(producersArray);
		
		moviesService.save(movies);		
	}
	
}
