package com.cinecloud.controller;

import com.cinecloud.controller.request.StreamingRequest;
import com.cinecloud.controller.response.StreamingResponse;
import com.cinecloud.entity.Streaming;
import com.cinecloud.mapper.StreamingMapper;
import com.cinecloud.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinecloud/streaming")
public class StreamingController {

    private final StreamingService streamingService;

    @PostMapping()
    public ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(StreamingMapper.toResponse(streamingService.save(StreamingMapper.toStreaming(request))));
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>>findAll(){
      return ResponseEntity.ok(streamingService.getAll().stream()
              .map(StreamingMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id){
        Optional<Streaming> optionalStreaming = streamingService.getById(id);
        return optionalStreaming.map(streaming -> ResponseEntity.ok
                (StreamingMapper.toResponse(streaming))).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        streamingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> update(@RequestBody  StreamingRequest request, @PathVariable Long id) {
        Optional<Streaming> OptionalStreaming = streamingService.getById(id);
        if(OptionalStreaming.isPresent()){
            Streaming streaming = StreamingMapper.toStreaming(request);
            streaming.setId(id);
            streamingService.update(streaming,id);
            return ResponseEntity.ok(StreamingMapper.toResponse(streaming));
        }
        return ResponseEntity.notFound().build();
    }


}
