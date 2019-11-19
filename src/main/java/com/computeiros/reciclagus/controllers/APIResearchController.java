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
        var r = collPointRep.findAll();
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
