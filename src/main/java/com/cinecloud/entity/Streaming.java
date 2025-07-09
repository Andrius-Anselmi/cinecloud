package com.cinecloud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "streaming")
public class Streaming {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String name;


}
