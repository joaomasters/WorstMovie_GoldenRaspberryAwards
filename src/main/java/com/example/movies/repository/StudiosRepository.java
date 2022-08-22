package com.example.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.model.Studios;

@Repository
public interface StudiosRepository extends JpaRepository<Studios, Long>{

}
