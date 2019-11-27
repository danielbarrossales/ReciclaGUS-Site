package com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.service.CollectionPointService;
import com.computeiros.reciclagus.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company-del/apagar-id")
public class ApagarCompanyController {

    @Autowired
    CompanyService companyService;

    /**
     *
     * @param companyId É o valor da variável passada na url depois de apagar-id/
     * @return Redireciona para a página de visualização de pontos de coleta, passando o parametro de sucesso ou falha ao apagar
     */
    @RequestMapping(method = RequestMethod.GET, value = "{companyId}")
    public String deleteCompanyPorId(@PathVariable Integer companyId) {
        if (companyService.ApagarPorId(companyId).isPresent()){
            return "redirect:/todos-empresas?falha_apagar";
        }
        return "redirect:/todos-empresa?sucesso_apagar";
    }
}
