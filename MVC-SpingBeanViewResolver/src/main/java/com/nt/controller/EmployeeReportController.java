package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;

public class EmployeeReportController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
	 EmployeeDTO dto1=null;
	 EmployeeDTO dto2=null;
	 EmployeeDTO dto3=null;
	 
	 List<EmployeeDTO> listDTO=null;
	 
	 dto1=new  EmployeeDTO();
	 dto1.setEid(101);
	 dto1.setEname("Charan");
	 dto1.setSalary(40000.0);
	 dto1.setAddrs("HYD");
	 
	 dto2=new  EmployeeDTO();
	 dto2.setEid(102);
	 dto2.setEname("Laxmi");
	 dto2.setSalary(42000.0);
	 dto2.setAddrs("Chennai");
	 
	 dto3=new  EmployeeDTO();
	 dto3.setEid(103);
	 dto3.setEname("Deepu");
	 dto3.setSalary(65000.0);
	 dto3.setAddrs("Chennai");
	 listDTO=new ArrayList();
	 listDTO.add(dto1);
	 listDTO.add(dto2);
	 listDTO.add(dto3);
	 
	 //return MAV object
	 if(req.getParameter("type").equalsIgnoreCase("pdf"))
		return new ModelAndView("pdfView", "listDTO", listDTO);
	 else
		 return new ModelAndView("excelView", "listDTO", listDTO);
	}

}
