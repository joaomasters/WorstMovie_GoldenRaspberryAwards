package com.example.movies.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_producers")
public class Producers implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long producersId;	
	@Column(name = "name")
	private String name;		
	@JoinColumn(name = "moviesId", nullable = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Movies movies;
	
	public Producers() {
		// TODO Auto-generated constructor stub
	}

	public Producers(long producersId, String name, Movies movies) {
		super();
		this.producersId = producersId;
		this.name = name;
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Producers [producersId=" + producersId + ", name=" + name + ", movies=" + movies + "]";
	}

	public long getProducersId() {
		return producersId;
	}

	public void setProducersId(long producersId) {
		this.producersId = producersId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(producersId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producers other = (Producers) obj;
		return producersId == other.producersId;
	}
	
}
