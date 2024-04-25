package com.riwi.toDoList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.toDoList.entities.Homework;
import com.riwi.toDoList.repository.HomeworkRepository;

@Service
public class HomeworkService {

    @Autowired
    private HomeworkRepository obHomeworkRepository;

    public List<Homework> listHomework(){
        return obHomeworkRepository.findAll();
    }


}
