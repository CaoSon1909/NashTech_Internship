package com.example.thirdtryspringbootapplication.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tblEmployee")
public class EmployeeEntity {

    @Id
    @GeneratedValue
    @Column(name = "empID",updatable = false, unique = true,nullable = false)
    private UUID id;
    @Column(name = "empName", length = 50, nullable = false)
    private String name;
    @Column(name = "empAddress")
    private String address;
    @Column(name = "empSalary", length = 18)
    private float salary;
    @Column(name = "empSex")
    private char gender;
    @Column(name = "empBirthdate", nullable = false)
    private LocalTime birthDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depID", referencedColumnName = "depID")
    private DepartmentEntity department;

    public EmployeeEntity() {
    }

    public EmployeeEntity(UUID id, String name, String address, float salary, char gender, LocalTime birthDate, DepartmentEntity department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
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

    public LocalTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalTime birthDate) {
        this.birthDate = birthDate;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
