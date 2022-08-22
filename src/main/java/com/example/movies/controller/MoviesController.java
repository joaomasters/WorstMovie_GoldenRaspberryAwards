package com.example.movies.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class MoviesController {

	@GetMapping(path="/movies/listar")
	public ResponseEntity<?> listar(){
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
}
