package com.cinecloud.controller;

import com.cinecloud.controller.request.MovieRequest;
import com.cinecloud.controller.response.MovieResponse;
import com.cinecloud.entity.Movie;
import com.cinecloud.mapper.MovieMapper;
import com.cinecloud.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinecloud/movie")
public class MovieController {

    private final MovieService movieService;

    @PostMapping()
    public ResponseEntity<MovieResponse> save (@RequestBody MovieRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(MovieMapper.toResponse(movieService.save(MovieMapper.toMovie(request))));
    }

    @GetMapping()
    public ResponseEntity<List<MovieResponse>> getAll(){
        return ResponseEntity.ok(movieService.findAll().stream().
                map(MovieMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getById(@PathVariable Long id){
        Optional<Movie> movieOptional = movieService.findById(id);
        return movieOptional.map(Movie -> ResponseEntity.ok(MovieMapper.toResponse(Movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieRequest request){
       return movieService.update(id,MovieMapper.toMovie(request))
               .map(movie -> ResponseEntity.ok(MovieMapper.toResponse(movie))).
               orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Movie> movieOptional = movieService.findById(id);
        if(movieOptional.isPresent()){
            movieService.delete(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> getMoviesByCategoryId(@RequestParam Long category){
        return ResponseEntity.ok(movieService.findByCategory(category).stream().map(MovieMapper::toResponse).toList());

    }


}
