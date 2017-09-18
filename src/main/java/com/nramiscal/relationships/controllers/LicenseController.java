package com.nramiscal.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nramiscal.relationships.models.License;
import com.nramiscal.relationships.services.LicenseService;
import com.nramiscal.relationships.services.PersonService;


@Controller
public class LicenseController {
	
	private final LicenseService licenseService;
	private final PersonService personService;
	private static Integer count = 0;
	
    public LicenseController(LicenseService licenseService, PersonService personService){
        this.licenseService = licenseService;
        this.personService = personService;
    }

    
    @RequestMapping("/newLicense")
    public String newLicense(Model model, @ModelAttribute("license") License license) {
    		model.addAttribute("persons", personService.allPersons());
    		return "newLicense";
    }
    
    
    @PostMapping("/newLicense")
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model, RedirectAttributes re) {
		if (result.hasErrors()) {
			re.addFlashAttribute("errs",result.getAllErrors());
	        model.addAttribute("persons", personService.allPersons());
			return "newLicense";
		}else {
			count++;
			String strId = Integer.toString(count);
			String number = strId;
			    if (count < 10) {
			        number = "00000" + strId;
			    }else if (count < 100){
			        number = "0000" + strId;
			    }else if (count < 1000) {
			        number = "000" + strId;
			    }else if (count < 10000) {
			        number = "00" + strId;
			    }else if (count < 100000) {
			        number = "0" + strId;
			    }

			license.setNumber(number);
			licenseService.addLicense(license);
			return "redirect:/";
		}
    }
    

	
}
