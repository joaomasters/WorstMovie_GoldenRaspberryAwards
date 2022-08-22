package com.example.movies.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_movies")
public class Movies implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long moviesId;
	@Column(name = "year", nullable = false, length = 4)
	private String year;
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	@Column(name = "winner", nullable = true, length = 3)
	private String winner;
	@OneToMany(mappedBy = "movies", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Studios> studios = new ArrayList<Studios>();
	@OneToMany(mappedBy = "movies", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Producers> producers = new ArrayList<Producers>();

	public Movies() {
		// TODO Auto-generated constructor stub
	}

	public Movies(long moviesId, String year, String title, String winner, List<Studios> studios, List<Producers> producers) {
		super();
		this.moviesId = moviesId;
		this.year = year;
		this.title = title;
		this.winner = winner;
		this.studios = studios;
		this.producers = producers;
	}

	@Override
	public String toString() {
		return "Movies [moviesId=" + moviesId + ", year=" + year + ", title=" + title + ", winner=" + winner
				+ ", studios=" + studios + ", producers=" + producers + "]";
	}

	public long getMoviesId() {
		return moviesId;
	}

	public void setMoviesId(long moviesId) {
		this.moviesId = moviesId;
	}

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

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
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

	@Override
	public int hashCode() {
		return Objects.hash(moviesId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return moviesId == other.moviesId;
	}

}
