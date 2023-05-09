package com.example.Student.controllers;

import com.example.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

public interface Repo extends JpaRepository<Student,Integer> {

}
