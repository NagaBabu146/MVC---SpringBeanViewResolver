package com.nt.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.EmployeeDTO;

public class EmployeePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// get Model Attribute
		List<EmployeeDTO>listDTO=null;
		listDTO=new ArrayList();
		listDTO=(List<EmployeeDTO>) map.get("listDTO");
		//add heading as paragrah
		Paragraph para =new Paragraph("Employees Details",new Font(Font.BOLD));
		doc.add(para);
		//add table having report content
		Table table= new Table(4,listDTO.size());
		
		for(EmployeeDTO dto:listDTO) {
		table.addCell(String.valueOf(dto.getEid()));
		table.addCell(dto.getEname());
		table.addCell(dto.getAddrs());
		table.addCell(String.valueOf(dto.getSalary()));
		}
		doc.add(table);
		
	}

}
