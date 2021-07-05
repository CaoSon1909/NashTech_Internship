package com.example.thirdtryspringbootapplication.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeDTO implements Serializable {
    private UUID id;
    private String name;
    private String address;
    private float salary;
    private char gender;
    private LocalDate birhDate;
    private int depID;

    public EmployeeDTO() {
    }

    public EmployeeDTO(UUID id, String name, String address, float salary, char gender, LocalDate birhDate, int depID) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
        this.birhDate = birhDate;
        this.depID = depID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirhDate() {
        return birhDate;
    }

    public void setBirhDate(LocalDate birhDate) {
        this.birhDate = birhDate;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }
}
