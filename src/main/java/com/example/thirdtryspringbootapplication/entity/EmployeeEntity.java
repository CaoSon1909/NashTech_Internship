package com.example.thirdtryspringbootapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tblEmployee")
public class EmployeeEntity implements Serializable {

    @Id
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
    @JoinColumn(name = "depID")
    @JsonBackReference
    private DepartmentEntity department;

    @Column(name = "depID",insertable = false, updatable = false)
    private int depID;

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

    public EmployeeEntity(@JsonProperty("id") UUID id
            , @JsonProperty("name") String name
            , @JsonProperty("address") String address
            , @JsonProperty("salary") float salary
            , @JsonProperty("gender") char gender
            , @JsonProperty("birthDate") LocalTime birthDate
            , @JsonProperty("depID") int depID) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
        this.birthDate = birthDate;
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

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }
}
