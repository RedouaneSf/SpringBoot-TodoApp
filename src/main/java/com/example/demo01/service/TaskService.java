package com.example.demo01.service;

import com.example.demo01.enitity.Task;
import com.example.demo01.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskService {
    @Autowired
    private TaskRepository tRespo;
    public void save(Task t){
        tRespo.save(t);
    }
    public List<Task> getAllTask(){
       return tRespo.findAll();
    }
    public Task getTaskById(int id)
    {
           return  tRespo.findById(id).get();
    }

    public  void deleteById(int id)
    {
        tRespo.deleteById(id);
    }
}
