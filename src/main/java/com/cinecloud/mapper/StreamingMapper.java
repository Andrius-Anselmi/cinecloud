package com.cinecloud.mapper;

import com.cinecloud.controller.request.StreamingRequest;
import com.cinecloud.controller.response.StreamingResponse;
import com.cinecloud.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass

public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming.builder()
                .name(request.name())
                .build();

    }

    public static StreamingResponse toResponse(Streaming streaming){
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }

}
