package com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.dto.CollectionPointRegistrationDto;
import com.computeiros.reciclagus.service.CollectionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/ponto-coleta/atualizar")
public class CollectionPointUpdateController {

    @Autowired
    private CollectionPointService collectionPointService;

    /**
     * Recebe entidade da view e manda para o service atualizar
     * @param userDto
     * @param result
     * @return
     */
    @PostMapping
    public String updateCollectionPoint(@ModelAttribute("collectionPoint") @Valid CollectionPointRegistrationDto userDto,
                                      BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            return "/todos-pontos-coleta";
        }

        if(collectionPointService.update(userDto) != null)
            return "redirect:/todos-pontos-coleta?sucesso_atualizar";
        return "redirect:/todos-pontos-coleta?falha_atualizar";
    }

}
