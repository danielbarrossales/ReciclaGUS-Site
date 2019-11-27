package com.computeiros.reciclagus.controllers;


import com.computeiros.reciclagus.service.CollectionPointService;
import com.computeiros.reciclagus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list-All-company")
public class ShowAllCompany {
    @Autowired
    CompanyService compService;

    @GetMapping
    String showAllCompany(Model model){
        model.addAttribute("companies", compService.findAll());

        return "list-company";
    }
}
