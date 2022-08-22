package com.example.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.model.Movies;
import com.example.movies.repository.MoviesRepository;
import com.example.movies.service.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService{
 
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Override
	public Movies save(Movies movies) {
		return moviesRepository.save(movies);	
	}
}
