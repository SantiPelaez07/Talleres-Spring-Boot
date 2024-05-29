package com.riwi.simulacro.domain.entities;

import java.util.List;

import com.riwi.simulacro.util.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String userName;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Role role;

    /* Relación con las inscripciones */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Enrollment> enrollments;

    /* Relación con cursos */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Course> courses;

    /* Relación con submission */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Submission> submissions;

    /* Relación con el senderId */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userSender", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Message> senderMessages;


    /* Relación con el receiverId */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userReceiver", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Message> receiverMessages;
}
