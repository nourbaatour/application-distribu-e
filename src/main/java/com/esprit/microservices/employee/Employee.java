package com.esprit.microservices.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID =6;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private int salary;
    private String position;
    private String hiringDate;
    private Boolean isActive;

    public Employee() {
    }

    public Employee(String name, String surname, int salary, String position, String hiringDate, Boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
        this.hiringDate = hiringDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
