package com.nt.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.nt.dto.EmployeeDTO;

public class EmployeeExcelView extends AbstractExcelView {

	@Override
	public void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		List<EmployeeDTO> listDTO=null;

		Sheet sheet=null;
		Row row=null;
		int j=0;
		int i=0;
	    //get Model Data
			listDTO=(List<EmployeeDTO>) map.get("listDTO");
			//create WorkSheet 
			sheet=workbook.createSheet("Employee Report");
			for(EmployeeDTO dto:listDTO) {
				
				j=0;
				row=sheet.createRow(i);
				row.createCell(j).setCellValue(dto.getEid());
				row.createCell(j+1).setCellValue(dto.getEname());
				row.createCell(j+2).setCellValue(dto.getAddrs());
				row.createCell(j+3).setCellValue(dto.getSalary());
			
				i++;
			}
		
	}

}
