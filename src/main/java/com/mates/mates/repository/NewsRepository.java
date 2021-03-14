package com.mates.mates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mates.mates.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{

}
