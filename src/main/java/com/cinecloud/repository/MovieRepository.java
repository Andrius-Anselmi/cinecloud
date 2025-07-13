package com.cinecloud.repository;

import com.cinecloud.entity.Category;
import com.cinecloud.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByCategories(List<Category> category);
}
