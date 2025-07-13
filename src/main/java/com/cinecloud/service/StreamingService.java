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

    public Optional<Streaming> update(Long streamingId, Streaming streaming){
        Optional<Streaming> OptionalStreaming = streamingRepository.findById(streamingId);
        if(OptionalStreaming.isPresent()){
            Streaming savedStreaming = OptionalStreaming.get();
            savedStreaming.setId(streamingId);
            savedStreaming.setName(streaming.getName());
            streamingRepository.save(streaming);
            return Optional.of(streaming);
        }

        return Optional.empty();
    }

    public void deleteById(Long id){
        streamingRepository.deleteById(id);
    }

}
