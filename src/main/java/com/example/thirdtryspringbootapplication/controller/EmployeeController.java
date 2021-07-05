package com.example.thirdtryspringbootapplication.controller;

import com.example.thirdtryspringbootapplication.dtos.EmployeeDTO;
import com.example.thirdtryspringbootapplication.entity.EmployeeEntity;
import com.example.thirdtryspringbootapplication.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    private UUID isValidUUID(String uuidString){
        try{
            return UUID.fromString(uuidString);
        }
        catch (IllegalArgumentException ex){
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity emp){
        int impactedRow = service.createEmployee(emp);
        if (impactedRow > 0){
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getEmployees(){
        List<EmployeeEntity> result = service.findAllEmployees();
        return result.isEmpty()
                ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeByID(@PathVariable("id") String id){
        UUID uuid = isValidUUID(id);
        if (uuid != null){
            Optional<EmployeeEntity> opt = service.findEmployeeByUUID(uuid);
            return opt
                    .map(employeeEntity -> new ResponseEntity<>(employeeEntity, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<EmployeeEntity>> getEmployeeLikeName(@PathVariable("name") String name){
        List<EmployeeEntity> opt = service.findEmployeeByName(name);
        return !opt.isEmpty()
                ? new ResponseEntity<>(opt, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<String> updateEmployeee(@RequestBody EmployeeEntity emp){
        return service.updateEmployee(emp) > 0
                ? new ResponseEntity<>("Updated", HttpStatus.OK)
                : new ResponseEntity<>("Update Fail", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path ="{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String uuidString){
        UUID uuid = isValidUUID(uuidString);
        if (uuid != null){
            return service.deleteEmployee(uuid) > 0
                    ? new ResponseEntity<>("Deleted", HttpStatus.OK)
                    : new ResponseEntity<>("Delete Fail", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Delete Fail", HttpStatus.NOT_FOUND);
    }

}
