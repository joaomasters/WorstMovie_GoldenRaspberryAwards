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
@Table(name = "tbl_studios")
public class Studios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studiosId;
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@JoinColumn(name = "moviesId", nullable = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Movies movies;

	public Studios() {
		// TODO Auto-generated constructor stub
	}

	public Studios(long studiosId, String name, Movies movies) {
		super();
		this.studiosId = studiosId;
		this.name = name;
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Studios [studiosId=" + studiosId + ", name=" + name + ", movies=" + movies + "]";
	}

	public long getStudiosId() {
		return studiosId;
	}

	public void setStudiosId(long studiosId) {
		this.studiosId = studiosId;
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
		return Objects.hash(studiosId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studios other = (Studios) obj;
		return studiosId == other.studiosId;
	}

}
