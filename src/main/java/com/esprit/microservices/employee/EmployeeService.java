package com.esprit.microservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long id,Employee newEmployee){
        if (employeeRepository.findById(id).isPresent()) {
            Employee existingEmployee = employeeRepository.findById(id).get();
            existingEmployee.setName(newEmployee.getName());
            existingEmployee.setSurname(newEmployee.getSurname());
            existingEmployee.setPosition(newEmployee.getPosition());
            existingEmployee.setSalary(newEmployee.getSalary());
            existingEmployee.setHiringDate(newEmployee.getHiringDate());
            existingEmployee.setActive(newEmployee.getActive());
            return employeeRepository.save(existingEmployee);
        } else
            return null;
    }

    public String deleteEmployee(int id) {
        if (employeeRepository.findById((long) id).isPresent()) {
            employeeRepository.deleteById((long) id);
            return "employee supprimé";
        } else
            return "employee non supprimé";
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


}
