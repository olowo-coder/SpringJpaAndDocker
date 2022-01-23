package com.example.springjpaanddocker.controller;

import com.example.springjpaanddocker.model.Employee;
import com.example.springjpaanddocker.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id){
        return ResponseEntity.ok().body(employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id: " + id + " not found")));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id: " + id + " not found"));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }


}
