package com.cinecloud.controller;

import com.cinecloud.entity.Streaming;
import com.cinecloud.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinecloud/streaming")
public class StreamingController {

    private final StreamingService streamingService;

    @PostMapping()
    public Streaming save(@RequestBody Streaming streaming){
        return streamingService.save(streaming);
    }

    @GetMapping()
    public List<Streaming> findAll(){
        return streamingService.getAll();
    }

    @GetMapping("/{id}")
    public Streaming getById(@PathVariable Long id){
        Optional<Streaming> OptionalStreaming = streamingService.getById(id);
        if(OptionalStreaming.isPresent()){
            return OptionalStreaming.get();
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        streamingService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Streaming update(@RequestBody  Streaming streaming, @PathVariable Long id) {
        Optional<Streaming> OptionalStreaming = streamingService.getById(id);
        if(OptionalStreaming.isPresent()){
            streaming.setId(id);
            return  streamingService.update(streaming,id);
        }
        return null;
    }


}
