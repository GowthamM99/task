package com.te.task1.helper;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.te.task1.entity.Employee;

public class Helper {
	public static boolean checkExcelFromat(MultipartFile file) {
		String type = file.getContentType();
		if(type.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		
		return false;
	}
	
	public static List<Employee> convertExcelToList(InputStream is){
		
	List list = new ArrayList<>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rownum=0;
			Iterator<Row> rows = sheet.iterator();
			while(rows.hasNext()) {
				Row currentRow = rows.next();
				if(rownum==0) {
					rownum++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				Employee employee = new Employee();
				int cellId=0;
				while(cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch(cellId) {
					case 0:
						employee.setFirstName(currentCell.getStringCellValue());
						break;
					case 1:
						employee.setLastName(currentCell.getStringCellValue());
						break;
					case 2:
						employee.setGender(currentCell.getStringCellValue());
						break;
					case 3:
						employee.setCountry(currentCell.getStringCellValue());
						break;
					case 4:
						employee.setAge((int)currentCell.getNumericCellValue());
						break;
					case 5:
						employee.setId((int)currentCell.getNumericCellValue());
						break;
					
					default:
						break;
					
					}
					cellId++;
					
				}
				list.add(employee);
			}
			workbook.close();		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
