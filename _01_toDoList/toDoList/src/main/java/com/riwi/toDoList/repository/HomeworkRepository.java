package com.riwi.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.toDoList.entities.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long>{

}
