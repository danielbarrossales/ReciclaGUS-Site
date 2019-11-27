package com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.dto.CollectionPointRegistrationDto;
import com.computeiros.reciclagus.dto.CompanyRegistrationDto;
import com.computeiros.reciclagus.service.CollectionPointService;
import com.computeiros.reciclagus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/company/atualizar")
public class CompanyUpdateController {

    @Autowired
    private CompanyService companyService;

    /**
     * Recebe entidade da view e manda para o service atualizar
     * @param userDto
     * @param result
     * @return
     */
    @PostMapping
    public String updateCompany(@ModelAttribute("companies") @Valid CompanyRegistrationDto userDto,
                                      BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result.getFieldErrors());
            return "/todos-empresas";
        }

        if(companyService.update(userDto) != null)
            return "redirect:/todos-pontos-coleta?sucesso_atualizar";
        return "redirect:/todos-pontos-coleta?falha_atualizar";
    }

}
