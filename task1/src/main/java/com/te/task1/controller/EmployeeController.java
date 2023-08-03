package com.te.task1.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.task1.helper.Helper;
import com.te.task1.response.SuccessResponse;
import com.te.task1.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/employee")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;

	@PostMapping(path = "/add")
	public ResponseEntity<SuccessResponse<String>> addDataFromExcelToDatabase(@RequestParam("file") MultipartFile file)
			throws IOException {
		if (Helper.checkExcelFromat(file)) {
			if (employeeService.addDataFromExcelToDatabase(file)) {
				return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().data("success")
						.message("data added succesfully to database from excel").build());
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(SuccessResponse.<String>builder().data("fail").message("failed to add the data").build());
	}
}
