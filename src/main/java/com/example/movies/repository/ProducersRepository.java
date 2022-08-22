package com.example.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.model.Producers;

@Repository
public interface ProducersRepository extends JpaRepository<Producers, Long>{

}
