package com.riwi.toDoList.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 255, nullable = true)
    private String description;
    @Column(nullable = false)
    private LocalDate day;
    @Column(nullable = false)
    private LocalTime hour;
    @Column(length = 50, nullable = false)
    private String status;

    public Homework() {}
    
    public Homework(Long id, String title, String description, LocalDate day, LocalTime hour, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.day = day;
        this.hour = hour;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Homework [id=" + id + ", name=" + title + ", description=" + description + ", day=" + day + ", Hour="
                + hour + "]";
    }


    
}
