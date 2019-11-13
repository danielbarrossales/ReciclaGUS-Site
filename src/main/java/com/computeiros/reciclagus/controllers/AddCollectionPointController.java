package com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.dto.CollectionPointDto;
import com.computeiros.reciclagus.service.CollectionPointService;
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
@RequestMapping("/add-collection-point")
public class AddCollectionPointController {

    @Autowired
    private CollectionPointService collectionPointService;

    @GetMapping
    public String showAddCollectionPointForm(Model model) {
        return "add-collection-point";
    }

    @ModelAttribute("collectionPoint")
    public CollectionPointDto userRegistrationDto() {
        return new CollectionPointDto();
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("collectionPoint") @Valid CollectionPointDto userDto,
                                      BindingResult result) {
        System.out.println("got here");
        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            return "add-collection-point";
        }

        collectionPointService.save(userDto);
        return "redirect:/add-collection-point?success";
    }
}
