package com.example.thirdtryspringbootapplication.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblDepartment")
public class DepartmentEntity {
    @Id
    @Column(name = "depID", updatable = false, unique = true, nullable = false)
    private int id;
    @Column(name = "depName", length = 50, nullable = false)
    private String name;
    @Column(name = "depAddress")
    private String address;
    @OneToMany(targetEntity = EmployeeEntity.class, mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<EmployeeEntity> employees;

    public DepartmentEntity() {
    }

    public DepartmentEntity(int id, String name, String address, List<EmployeeEntity> employees) {
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

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
