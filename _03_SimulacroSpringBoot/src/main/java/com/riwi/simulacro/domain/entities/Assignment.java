package com.riwi.simulacro.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "assigment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 80, nullable = false)
    private String title;
    @Lob
    @Column(length = 500, nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate date;

    /* Relación con las lecciones */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessonId", referencedColumnName = "id")
    private Lesson lesson;


    /* Relación con assignment */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "assignment", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Submission> submissions;
 }
