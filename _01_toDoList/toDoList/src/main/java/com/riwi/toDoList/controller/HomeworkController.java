package com.riwi.toDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.toDoList.service.HomeworkService;

@Controller
@RequestMapping("/homeworks")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;
    
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("listHomework", homeworkService.listHomework());
        return "viewHomework";
    }
}
