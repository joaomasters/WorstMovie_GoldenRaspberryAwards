package com.example.movies.dto;

import java.io.Serializable;
import java.util.List;

import com.example.movies.model.Producers;
import com.example.movies.model.Studios;

public class MoviesDTO implements Serializable {

	private static final long serialVersionUID = -5500457328919685883L;

	private String year;
	private String title;
	private List<Studios> studios;
	private List<Producers> producers;
	private String winner;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Studios> getStudios() {
		return studios;
	}

	public void setStudios(List<Studios> studios) {
		this.studios = studios;
	}

	public List<Producers> getProducers() {
		return producers;
	}

	public void setProducers(List<Producers> producers) {
		this.producers = producers;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

}
