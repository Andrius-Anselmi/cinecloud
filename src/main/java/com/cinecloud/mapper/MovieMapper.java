package com.cinecloud.mapper;

import com.cinecloud.controller.request.MovieRequest;
import com.cinecloud.controller.response.CategoryResponse;
import com.cinecloud.controller.response.MovieResponse;
import com.cinecloud.controller.response.StreamingResponse;
import com.cinecloud.entity.Category;
import com.cinecloud.entity.Movie;
import com.cinecloud.entity.Streaming;
import com.cinecloud.repository.StreamingRepository;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {


    public static Movie toMovie(MovieRequest request){

        List<Streaming> streamings = request.streamings().stream().map
                    (streaming_id -> Streaming.builder().id(streaming_id).build()).toList();


        List<Category> categories = request.categories().stream()
                    .map(category_id -> Category.builder().id(category_id).build()).toList();


        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .rating(request.rating())
                .releaseDate(request.releaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toResponse (Movie movie){

        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(CategoryMapper::toCategoryResponse).toList();

        List<StreamingResponse> streamings = movie.getStreamings().stream()
                .map(StreamingMapper::toResponse).toList();

        return MovieResponse.builder()
                .id((movie.getId()))
                .title(movie.getTitle())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
