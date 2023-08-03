package com.te.task1.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {

	boolean addDataFromExcelToDatabase(MultipartFile file);

}
