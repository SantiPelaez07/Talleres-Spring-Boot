package com.riwi.simulacro.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "message")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(length = 500, nullable = false)
    private String messageContent;
    @Column(nullable = false)
    private LocalDateTime dateTime;

    /* Relación con el senderId */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId", referencedColumnName = "id")
    private User userSender;

    /* Relación con el receiverId */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverId", referencedColumnName = "id")
    private User userReceiver;

    /* Relación con los cursos */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course", referencedColumnName = "id")
    private Course course;
}
