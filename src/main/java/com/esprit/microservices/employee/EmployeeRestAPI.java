package com.esprit.microservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
public class EmployeeRestAPI {
    private String hello = "Hello I'm An Employee";


    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int id,
                                                   @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee((long) id, employee),
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

}
