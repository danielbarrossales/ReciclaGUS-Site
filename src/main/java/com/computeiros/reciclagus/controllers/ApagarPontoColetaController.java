package com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.service.CollectionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ponto-coleta/apagar-id")
public class ApagarPontoColetaController {

    @Autowired
    CollectionPointService collPointService;

    /**
     *
     * @param pontoColetaId É o valor da variável passada na url depois de apagar-id/
     * @return Redireciona para a página de visualização de pontos de coleta, passando o parametro de sucesso ou falha ao apagar
     */
    @RequestMapping(method = RequestMethod.GET, value = "{pontoColetaId}")
    public String deletePontoColetaPorId(@PathVariable Integer pontoColetaId) {
        if (collPointService.ApagarPorId(pontoColetaId).isPresent()){
            return "redirect:/todos-pontos-coleta?falha_apagar";
        }
        return "redirect:/todos-pontos-coleta?sucesso_apagar";
    }
}
