package com.demo.FinalProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.demo.FinalProject.Model.Employee;
import com.demo.FinalProject.Service.EmpService;
import jakarta.servlet.http.HttpSession;

@Controller        //================= Define Controller ====================

public class EmpController {
	
	@Autowired
	private EmpService empService;
	
//================================ Get Mapping ==================================
	
	
	@GetMapping("/")
	public String index(Model m) {
		List<Employee> list = empService.getAllEmp();
		m.addAttribute("empList",list);
		return "index";
	}
	
	@GetMapping("/EmpSave")
	public String EmpSave() {
		return "emp_save";
	}
	
	@GetMapping("/EditEmp/{id}")
	public String EditEmp(@PathVariable int id, Model m) {
		// System.out.println(id);
		Employee emp = empService.getEmpById(id);
		m.addAttribute("emp", emp);
		return "emp_edit";
	}	
	
//================================ Post Mapping ==================================
    
	@PostMapping("/loadEmpSave")
	public String loadSaveEmp(@ModelAttribute Employee emp, HttpSession session) {
		//System.out.println(emp);
		Employee newEmp = empService.saveEmp(emp);

		if (newEmp != null) {
			//System.out.println("save success");
			session.setAttribute("msg", "Register sucessfully");
		} else {
			 //System.out.println("something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/EmpSave";
	}
	
	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {
		// System.out.println(emp);

		Employee updateEmp = empService.saveEmp(emp);

		if (updateEmp != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Update sucessfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}

		return "redirect:/";
	}
	
//================================ Get Mapping ==================================
	
	@GetMapping("/deleteEmp/{id}")
	public String loadEmpSave(@PathVariable int id, HttpSession session) {
		boolean f = empService.deleteEmp(id);
		if (f) {
			session.setAttribute("msg", "Delete sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}
		return "redirect:/";
	}

}
