package com.example.employeedb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class Tokens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private Long token_id;

    @Column(name = "token")
    private String token;

}
