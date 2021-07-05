package com.example.thirdtryspringbootapplication.service;

import com.example.thirdtryspringbootapplication.dtos.EmployeeDTO;
import com.example.thirdtryspringbootapplication.entity.EmployeeEntity;
import com.example.thirdtryspringbootapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeRepository getRepository() {
        return repository;
    }

    //this will manage CRUD operations of entities
    @PersistenceContext
    private EntityManager entityManager;

    //Get All employees
    public List<EmployeeEntity> findAllEmployees(){
        return repository.findAll();
    }
    //Get an employee by ID
    public Optional<EmployeeEntity> findEmployeeByUUID(UUID uuid){
        return repository.findById(uuid);
    }
    //Get employees have name like
    public List<EmployeeEntity> findEmployeeByName(String name){
        return repository.findEmployeeLikeName(name);
    }
    //Create an employee
    @Transactional
    public int createEmployee(EmployeeEntity emp){
        UUID uuid = UUID.randomUUID();
        return entityManager.createNativeQuery("INSERT INTO tblEmployee " +
                "(empID, empName, empAddress, empSalary, empSex, empBirthdate, depID) " +
                "VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, uuid)
                .setParameter(2, emp.getName())
                .setParameter(3, emp.getAddress())
                .setParameter(4, emp.getSalary())
                .setParameter(5, emp.getGender())
                .setParameter(6, emp.getBirthDate())
                .setParameter(7, emp.getDepID())
                .executeUpdate();
    }
    //Update an employee
    @Transactional
    public int updateEmployee(EmployeeEntity emp){
        boolean isExisted = repository.existsById(emp.getId());
        return isExisted ?
                entityManager
                        .createNativeQuery("UPDATE tblEmployee " +
                                "SET empName = ?, empAddress = ?, " +
                                "empSalary = ?, empSex = ?, " +
                                "empBirthdate = ?, depID = ? " +
                                "WHERE empID = ?")
                        .setParameter(1, emp.getName())
                        .setParameter(2, emp.getAddress())
                        .setParameter(3, emp.getSalary())
                        .setParameter(4, emp.getGender())
                        .setParameter(5, emp.getBirthDate())
                        .setParameter(6, emp.getDepID())
                        .setParameter(7, emp.getId())
                        .executeUpdate()
                : 0;

    }

    //Delete employee
    @Transactional
    public int deleteEmployee(UUID uuid){
        boolean isExisted = repository.existsById(uuid);
        return isExisted ?
                entityManager
                        .createNativeQuery("DELETE FROM tblEmployee " +
                        "WHERE empID = ?")
                        .setParameter(1, uuid)
                        .executeUpdate()
                : 0;
    }

}
