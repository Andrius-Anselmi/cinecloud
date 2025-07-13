package com.cinecloud.service;

import com.cinecloud.entity.Category;
import com.cinecloud.entity.Movie;
import com.cinecloud.entity.Streaming;
import com.cinecloud.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie){
        movie.setCategories(categories(movie.getCategories()));
        movie.setStreamings(streamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> update(Long movieId, Movie movieUpdate) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {

            List<Streaming> streamings = streamings(movieUpdate.getStreamings());
            List<Category> categories = categories(movieUpdate.getCategories());

            Movie movie = optionalMovie.get();
            movie.setTitle(movieUpdate.getTitle());
            movie.setDescription(movieUpdate.getDescription());
            movie.setRating(movieUpdate.getRating());
            movie.setReleaseDate(movieUpdate.getReleaseDate());
            movie.getCategories().clear();
            movie.getCategories().addAll(categories);
            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);
            movieRepository.save(movie);

            return Optional.of(movie);
        }

        return Optional.empty();
    }

    public void delete(Long id){
        movieRepository.deleteById(id);
    }

    public List<Movie> findByCategory(Long categoryId){
        return movieRepository.findByCategories(List.of(Category.builder().id(categoryId).build()));
    }


    private List<Streaming> streamings(List<Streaming> streamings){
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.getById(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }

    private List<Category> categories(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.getById(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }









}
