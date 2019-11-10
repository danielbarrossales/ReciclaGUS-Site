package com.computeiros.reciclagus.com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    ICompanyRepository compRepo;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("companies", compRepo.findAll());
        return "index";
    }

}
