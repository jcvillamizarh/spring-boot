package com.platzi.springboot.fundamentals.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "post")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @NonNull
    @Column(name = "description", length = 255)
    private String description;

    @NonNull
    @ManyToOne
    @JsonBackReference
    private User user;


}
