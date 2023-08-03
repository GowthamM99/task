package com.te.task1.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.te.task1.entity.Employee;
import com.te.task1.helper.Helper;
import com.te.task1.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	@Override
	public boolean addDataFromExcelToDatabase(InputStream inputStream) {
		
		List<Employee> employees = Helper.convertExcelToList(inputStream);
		employees.stream().forEach(s->employeeRepository.save(s));
		return true;
	}

}
