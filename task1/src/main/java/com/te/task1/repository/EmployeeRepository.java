package com.te.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.task1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
