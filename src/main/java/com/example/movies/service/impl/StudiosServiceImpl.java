package com.example.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.model.Studios;
import com.example.movies.repository.StudiosRepository;
import com.example.movies.service.StudiosService;

@Service
public class StudiosServiceImpl implements StudiosService{

	@Autowired
	private StudiosRepository studiosRepository;
	
	@Override
	public Studios save(Studios studios) {
		return studiosRepository.save(studios);	
	}
	
}
