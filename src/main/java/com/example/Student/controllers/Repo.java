package com.example.Student.controllers;

import com.example.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import java.util.List;

public interface Repo extends JpaRepository<Student,Integer> {
    List<Student> findByAge(int age); //jpa provide imple for them, findBy common for all ateibutes
    //its like where   and    ;
    List<Student> findByAgeAndMarks(int age, int marks); // checking by two fields eqUL TO AGE and marks equal to given
 // for custom quries we write @Query
//    1. native true means pure sql
 @Query(value = "select * from Student s where s.age > :age",nativeQuery = true)
 List<Student> getAllStudentsGreaterTha(int age); //colon for checking with param
    //    2. native flase means hibernate ql (hql)
    @Query(value = "select s from Student s where s.age > :age",nativeQuery = false)
    List<Student> getAllStudentsGreaterThan(int age);
}
