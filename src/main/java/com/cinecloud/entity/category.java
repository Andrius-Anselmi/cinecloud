package com.cinecloud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String name;


}
