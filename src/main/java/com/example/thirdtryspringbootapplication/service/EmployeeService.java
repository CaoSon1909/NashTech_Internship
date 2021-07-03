package com.example.thirdtryspringbootapplication.service;

import com.example.thirdtryspringbootapplication.entity.EmployeeEntity;
import com.example.thirdtryspringbootapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    public Iterable findAllEmployee(){
        return repository.findAll();
    }
    //Get an employee by ID
    public Optional<EmployeeEntity> findEmployeeByUUID(UUID uuid){
        return repository.findById(uuid);
    }
    //Get employees have name like
    public Optional<EmployeeEntity> findEmployeeByName(String name){
        return repository.findByNameLike(name);
    }
    //Create an employee
    @Transactional
    public int createEmployee(EmployeeEntity emp){
        return entityManager.createNativeQuery("INSERT INTO tblEmployee " +
                "(empID, empName, empAddress, empSalary, empSex, empBirthdate, depID) " +
                "VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, emp.getId())
                .setParameter(2, emp.getName())
                .setParameter(3, emp.getAddress())
                .setParameter(4, emp.getSalary())
                .setParameter(5, emp.getGender())
                .setParameter(6, emp.getBirthDate())
                .setParameter(7, emp.getDepartment().getId())
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
                        .setParameter(6, emp.getDepartment().getId())
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
