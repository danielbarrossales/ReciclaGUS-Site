package com.computeiros.reciclagus.service;

import com.computeiros.reciclagus.dto.CollectionPointRegistrationDto;
import com.computeiros.reciclagus.models.CollectionPoint;
import com.computeiros.reciclagus.repositories.CollectionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionPointService {
    @Autowired
    CollectionPointRepository collPointRepo;

    public CollectionPoint save(CollectionPointRegistrationDto newCollPoint){
        var collPoint = new CollectionPoint();
        collPoint.getAddress().setCity(newCollPoint.getCity());
        collPoint.getAddress().setComplement(newCollPoint.getComplement());
        collPoint.getAddress().setNumber(newCollPoint.getNumber());
        collPoint.getAddress().setState(newCollPoint.getState());
        collPoint.getAddress().setStreet(newCollPoint.getStreet());
        collPoint.getAddress().setNeighborhood(newCollPoint.getNeighborhood());
        return collPointRepo.save(collPoint);
    }
}
