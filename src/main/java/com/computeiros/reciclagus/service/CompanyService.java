package com.computeiros.reciclagus.service;

import com.computeiros.reciclagus.dto.CompanyRegistrationDto;
import com.computeiros.reciclagus.models.Company;
import com.computeiros.reciclagus.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository compRepo;

    /**
     *
     * @param companyDto Usa os dados para criar uma entidade e salva-la no banco de dado
     * @return retorna objeto salvo, se houver acontecido algum erro retorna objeto vazio.
     */
    public Company save(CompanyRegistrationDto companyDto){
        return compRepo.save(companyFromDto(companyDto));
    }

    public Company findByCnpj(CompanyRegistrationDto companyDto){
        return compRepo.findByCnpj(companyDto.getCnpj());
    }

    private Company companyFromDto(CompanyRegistrationDto companyDto){
        Company com = new Company();
        com.getAddress().setNeighborhood(companyDto.getNeighborhood());
        com.getAddress().setStreet(companyDto.getStreet());
        com.getAddress().setState(companyDto.getState());
        com.getAddress().setStreet(companyDto.getStreet());
        com.getAddress().setNumber(companyDto.getNumber());
        com.getAddress().setComplement(companyDto.getComplement());
        com.getAddress().setCity(companyDto.getCity());
        com.setCnpj(companyDto.getCnpj());
        com.setNome(companyDto.getName());
        return com;
    }
}
