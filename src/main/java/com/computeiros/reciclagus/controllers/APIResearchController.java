package com.computeiros.reciclagus.controllers;

import com.computeiros.reciclagus.api.examples.Research;
import com.computeiros.reciclagus.models.*;
import com.computeiros.reciclagus.repositories.CollectionPointRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class APIResearchController {
    @Autowired
    CollectionPointRepository collPointRep;

    @RequestMapping(value = "/api/research", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String researchApi(){

        //
        //
        Address add = new Address();
        add.setCity("Gus");
        add.setComplement("Nenhum");
        add.setNumber(1234);
        add.setId(1);
        add.setState("PE");
        add.setStreet("Alguma");
        add.setNeighborhood(("Bairro"));
        Trash t = new Trash();
        t.setId(1);
        t.setType("Eletronico");
        Phone phone = new Phone();

        phone.setDdd(87);
        phone.setId(1);
        phone.setNumero(981555161l);

        CollectionCompany comp = new CollectionCompany();
        comp.addTelefone(phone);
        comp.setAddress(add);
        comp.setCnpj("xxxxxxxxxxxxxx");
        comp.setId(1);
        comp.setNome("Empresa Fantasia");
        phone.setCompany(comp);
        Set<Trash> targets = new HashSet<Trash>();
        targets.add(t);
        comp.setTargets(targets);

        CollectionPoint collP = new CollectionPoint();
        collP.setAddress(add);
        collP.setHost(comp);
        collP.setTrashes(targets);

        List<CollectionPoint> list = new ArrayList<CollectionPoint>();
        list.add(collP);
        //
        //
        Research r = new Research();
        r.setTrashType("Eletronico");
        ObjectMapper mapper = new ObjectMapper();
        String answer = null;
        try {
            answer = mapper.writeValueAsString(r);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return answer;
    }

}
