package com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.dto.CompanyRegistrationDto;
import com.computeiros.reciclagus.models.Company;
import com.computeiros.reciclagus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register-company")
public class AddCompanyController {
    @Autowired
    CompanyService compServ;

    @ModelAttribute("company")
    public CompanyRegistrationDto companyRegistrationDto() {return new CompanyRegistrationDto();}

    @GetMapping
    public String showCompanyRegistrationForm(Model model){return "register-company";}

    @PostMapping
    public String registerCompany(@ModelAttribute("company") @Valid CompanyRegistrationDto companyDto,
                                  BindingResult result){
        Company existing = compServ.findByCnpj(companyDto);
        System.out.println("got here");
        if(existing != null){
            result.rejectValue("cnpj", null, "Já existe uma empresa cadastrada com esse cnpj");
        }

        if (result.hasErrors()) {
            return "register-company";
        }

        compServ.save(companyDto);

        return "redirect:register-company?success";
    }

}
