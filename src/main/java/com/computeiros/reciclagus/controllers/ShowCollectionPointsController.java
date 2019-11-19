package com.computeiros.reciclagus.controllers;


import com.computeiros.reciclagus.dto.CollectionPointRegistrationDto;
import com.computeiros.reciclagus.service.CollectionPointService;
import com.computeiros.reciclagus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/todos-pontos-coleta")
public class ShowCollectionPointsController {
    @Autowired
    CollectionPointService collService;

    @GetMapping
    String showAllCollectionPoints(Model model){
        model.addAttribute("collectionPoints", collService.findAll());
        return "collection-points";
    }
}
