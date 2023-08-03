package com.te.task1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.te.task1.entity.Employee;
import com.te.task1.helper.Helper;
import com.te.task1.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	@Override
	public boolean addDataFromExcelToDatabase(MultipartFile file) {
		List<Employee> employees = Helper.convertExcelToList(file);
		employeeRepository.saveAll(employees);
		return true;
	}

}
