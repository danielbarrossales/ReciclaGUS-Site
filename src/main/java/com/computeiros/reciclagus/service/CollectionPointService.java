package com.computeiros.reciclagus.service;

import com.computeiros.reciclagus.dto.CollectionPointRegistrationDto;
import com.computeiros.reciclagus.models.CollectionPoint;
import com.computeiros.reciclagus.repositories.CollectionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionPointService {
    @Autowired
    CollectionPointRepository collPointRepo;

    public List<CollectionPointRegistrationDto> findAll() {
        var list = new ArrayList<CollectionPointRegistrationDto>();
        for(CollectionPoint cp : collPointRepo.findAll()){
            list.add(collectionDtoFrom(cp));
        }
        return list;
    }

    private CollectionPointRegistrationDto collectionDtoFrom(CollectionPoint colle) {
        var dto = new CollectionPointRegistrationDto();
        dto.setCity(colle.getAddress().getCity());
        dto.setComplement(colle.getAddress().getComplement());
        dto.setNeighborhood(colle.getAddress().getNeighborhood());
        dto.setNumber(colle.getAddress().getNumber());
        dto.setState(colle.getAddress().getState());
        dto.setStreet(colle.getAddress().getStreet());
        dto.setId(colle.getId());
        return dto;
    }

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

    /**
     * Atualiza os dados de uma entidade no banco de dados
     * @param collPointdto
     * @return retorna a entidade atualizada
     */
    public CollectionPoint update(CollectionPointRegistrationDto collPointdto){
        var collPointOptional = collPointRepo.findById(collPointdto.getId());
        CollectionPoint collPoint = null;
        if (collPointOptional.isPresent()){
            collPoint = collPointOptional.get();
            if(collPoint.getAddress().getCity() != collPointdto.getCity())
                collPoint.getAddress().setCity(collPointdto.getCity());
            if(collPoint.getAddress().getComplement() != collPointdto.getComplement())
                collPoint.getAddress().setComplement(collPointdto.getComplement());
            if(collPoint.getAddress().getNeighborhood() != collPointdto.getNeighborhood())
                collPoint.getAddress().setNeighborhood(collPointdto.getNeighborhood());
            if(collPoint.getAddress().getNumber() != collPointdto.getNumber())
                collPoint.getAddress().setNumber(collPointdto.getNumber());
            if(collPoint.getAddress().getState() != collPointdto.getCity())
                collPoint.getAddress().setState(collPointdto.getState());
            if(collPoint.getAddress().getStreet() != collPointdto.getStreet())
                collPoint.getAddress().setStreet(collPointdto.getStreet());
            collPointRepo.save(collPoint);
        }

        return collPoint;
    }

    /**
     * Encontra objeto no banco de dados com o mesmo id que foi passado, e o retorna.
     * @param pontoColetaId Id do ponto de coleta a ser retornado
     * @return Objeto encontrado no banco de dados
     */
    public Optional<CollectionPoint> ApagarPorId(Integer pontoColetaId) {
        collPointRepo.deleteById(pontoColetaId);
        Optional<CollectionPoint> collPoint = collPointRepo.findById(pontoColetaId);
        return collPoint;
    }
}
