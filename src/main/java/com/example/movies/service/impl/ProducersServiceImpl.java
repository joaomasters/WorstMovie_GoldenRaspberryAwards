package com.example.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.model.Producers;
import com.example.movies.repository.ProducersRepository;
import com.example.movies.service.ProducersService;

@Service
public class ProducersServiceImpl implements ProducersService{

	@Autowired
	private ProducersRepository producersRepository;
	
	@Override
	public Producers save(Producers producers) {
		return producersRepository.save(producers);
	}

}
