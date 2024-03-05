package com.example.demo01.controller;

import com.example.demo01.enitity.Task;
import com.example.demo01.repository.TaskRepository;
import com.example.demo01.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class taskController {
    @Autowired
    private TaskService service;

    //home page function
    @GetMapping("/")
    public  String home()
    {
        return  "home";
    }
    //Add task page function
    @GetMapping("/task_add")
    public String AddTask()
    {
        return "AddTask";
    }
    //get all tasks function page function
    @GetMapping("/task_all")
    public ModelAndView AllTasks()
    {
        List<Task>list=service.getAllTask();
        return new ModelAndView("AllTasks","task",list);
    }



   //Post methode to add task into Db
    @PostMapping("/save")
    public String addTask(@ModelAttribute Task t)
    {
        service.save(t);
      return "redirect:/task_all";
    }

    @RequestMapping("/myTask/{id}")
    public String getMyTask(@PathVariable("id")int id)
    {
        Task t = service.getTaskById(id);
        return "redirect:/task_id";
    }
    //delete methode to delete task from Db
    @RequestMapping("deleteTask/{id}")
    public  String deleteTask(@PathVariable("id")int id)
    {
        service.deleteById(id);

        return "redirect:/task_all";
    }
    //Edit methode to update task values
    @RequestMapping("/edit_task/{id}")
    public String EditTasks(@PathVariable("id") int id, Model model)
    {
       Task t= service.getTaskById(id);
       model.addAttribute("task",t);
        return "EditTask";
    }

}

