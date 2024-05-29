package com.riwi.simulacro.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(length = 500,nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private double grade;


    /* Relación con el user */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;


    /* Relación con la tarea */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment", referencedColumnName = "id")
    private Assignment assignment;
}
