package com.cinecloud.service;

import com.cinecloud.entity.Category;
import com.cinecloud.entity.Movie;
import com.cinecloud.entity.Streaming;
import com.cinecloud.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie){
        movie.setCategories(categories(movie));
        movie.setStreamings(streamings(movie));
        return movieRepository.save(movie);
    }

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }

    public void delete(Long id){
        movieRepository.deleteById(id);
    }

    private List<Streaming> streamings(Movie movie){
        List<Streaming> streamings = movie.getStreamings();
        List<Streaming> streamingsDB = streamingService.getAll();
        List<Long> streamingIds = streamings.stream()
                .map(streaming -> streaming.getId()).toList();

        return streamingsDB.stream().filter(streaming -> streamingIds.contains(streaming.getId())).toList();
    }

    private List<Category> categories(Movie movie){
        List<Category> categories = movie.getCategories();
        List<Category> categoriesDB = categoryService.getAll();
        List<Long> categoriesIds = categories.stream().
                map(category -> category.getId()).toList();

        return categoriesDB.stream().filter(category -> categoriesIds.contains(category.getId())).toList();

    }


}
