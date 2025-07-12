package com.cinecloud.controller.response;

import com.cinecloud.entity.Category;
import com.cinecloud.entity.Streaming;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        double rating,
        List<CategoryResponse> categories,
        List<StreamingResponse> streamings
) {
}
