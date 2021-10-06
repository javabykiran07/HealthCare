package com.kiran.healthcare.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kiran.healthcare.entity.Specialization;
import com.kiran.healthcare.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	@Autowired
	private ISpecializationService service;

	/*
	 * show register page
	 */
	@GetMapping("/register")
	public String dispalyRegister() {
		return "SpecializationRegister";

	}

	/*
	 * on submit form save data
	 */
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Specialization specialization, Model model) {
		Long id = service.saveSpecialization(specialization);
		String message = "Record (" + id + ") is created";
		model.addAttribute("message", message);
		return "SpecializationRegister";
	}

	/*
	 * display all
	 */
	@GetMapping("/all")
	public String viewAll(Model model, @RequestParam(value = "message", required = false) String message) {
		List<Specialization> list = service.getAll();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "SpecializationData";
	}

	/*
	 * delete Specialization
	 */
	@GetMapping("/delete")
	public String deleteData(@RequestParam Long id, RedirectAttributes attributes) {
		service.removeSpecialization(id);
		attributes.addAttribute("message", "Record (" + id + ") is deleted");
		return "redirect:all";

	}

}
