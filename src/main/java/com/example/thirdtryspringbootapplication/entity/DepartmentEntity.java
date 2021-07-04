package com.example.thirdtryspringbootapplication.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblDepartment")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class DepartmentEntity {
    @Id
    @Column(name = "depID", updatable = false, unique = true, nullable = false)
    private int id;
    @Column(name = "depName", length = 50, nullable = false)
    private String name;
    @Column(name = "depAddress")
    private String address;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(nullable = true)
    @JsonManagedReference
    private Set<EmployeeEntity> employees = new HashSet<>();

    public DepartmentEntity() {
    }

    public DepartmentEntity(int id, String name, String address, Set<EmployeeEntity> employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
