package com.cinecloud.service;

import com.cinecloud.entity.Streaming;
import com.cinecloud.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public Streaming save(Streaming streaming){
        return streamingRepository.save(streaming);
    }

    public Optional<Streaming> getById(Long id){
        return streamingRepository.findById(id);
    }

    public List<Streaming> getAll(){
        return streamingRepository.findAll();
    }

    public Streaming update(Streaming streaming, Long id){
        Optional<Streaming> OptionalStreaming = streamingRepository.findById(id);
        if(OptionalStreaming.isPresent()){
            Streaming savedStreaming = OptionalStreaming.get();
            savedStreaming.setId(streaming.getId());
            savedStreaming.setName(streaming.getName());
            return streamingRepository.save(streaming);
        }

        return null;
    }

    public void deleteById(Long id){
        streamingRepository.deleteById(id);
    }

}
