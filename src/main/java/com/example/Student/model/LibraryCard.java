package com.example.Student.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING) //genrly sql has no enum type so we have specify typem of store
    private Department department;

    @CreationTimestamp   // to automatically assign creation date;
    private Date issueDate;

    @UpdateTimestamp  // automatically update the last date of operation
    private Date lastTransactionDate;

    @OneToOne // for the creation realtion btrwn two entities in db
    @JoinColumn //adding forgin key in child table , we invidualy add stu id to card by taking stu obj as only id of it
    Student student;
 //joincol is searches for the pk in student, and make as fk, if we want to amke spl attribute as fk
    // colmn(age) like this

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(Date lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
