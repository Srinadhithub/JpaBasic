package com.example.Student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
//    @Column(name="full_name")
    private  String name;
    private  int age;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) // cascade is type of oper that also perform on childs
    LibraryCard libraryCard; // it cnt create field in table  we just linking that parent to child bidirectional
public Student(){

}
    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

}
