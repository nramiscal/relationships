package com.nramiscal.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nramiscal.relationships.models.Person;
import com.nramiscal.relationships.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;
	
	
	public PersonController(PersonService personService){
		this.personService = personService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/newPerson";
	}
	
	@RequestMapping("/newPerson")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson";
	}
	
	@PostMapping("/newPerson")
	public String create(Model model, @Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "newPerson";
		}else {
			personService.addPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String showInfo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("person", personService.findPersonByIndex(id));
		return "profile";
	}
}
