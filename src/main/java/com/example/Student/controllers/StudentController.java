package com.example.Student.controllers;

import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    Repo repository;
    @PostMapping("/add")
    public String addStuent(@RequestBody Student student){
        repository.save(student);
        return "Sucess";
    }
    @GetMapping("/get/{id}")
    public Student get(@PathVariable int id){
        //for simplification this method trho eexcep so, get(). used to tell us
        return repository.findById(id).get();
        //findid returns optional so we have to get obj from it so .get().
    }
    @GetMapping("/getall")
    public List<Student> getAll(){
        return repository.findAll();
    }
    @DeleteMapping("/deteteid/{id}")
    public String deleteById(@PathVariable int id){
         repository.deleteById(id);
         return id+"deleted";
    }
    @DeleteMapping("/deteteall")
    public String deleteAll(){
        repository.deleteAll();
        return "All deleted";
    }
    @PutMapping("/updatename")
    public String updateName(@RequestParam int id,@RequestParam String name){
      Student student= repository.findById(id).get();
      student.setName(name);
      repository.save(student);
      return "updtated";
    }

}
