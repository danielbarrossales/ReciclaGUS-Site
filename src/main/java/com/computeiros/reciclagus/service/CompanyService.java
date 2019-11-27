package com.computeiros.reciclagus.service;

import com.computeiros.reciclagus.dto.CollectionPointRegistrationDto;
import com.computeiros.reciclagus.dto.CompanyRegistrationDto;
import com.computeiros.reciclagus.models.Company;
import com.computeiros.reciclagus.models.ListCompany;
import com.computeiros.reciclagus.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository compAllRepo;

   public List<CompanyRegistrationDto> findAll(){
       var list = new ArrayList<CompanyRegistrationDto>();
       for(Company lc: compAllRepo.findAll()){
           list.add(dtoFromCompany(lc));
       }
       return list;
   }

    /**
     *
     * @param companyDto entidade a ser serializado
     * @return retorna a entidade salva no banco de dados
     */
    public Company save(CompanyRegistrationDto companyDto){
        return compAllRepo.save(companyFromDto(companyDto));
    }

    public Company findByCnpj(CompanyRegistrationDto companyDto){
        var temp = compAllRepo.findByCnpj(companyDto.getCnpj());
        return temp.isPresent() ? temp.get() : null;
    }

    private CompanyRegistrationDto dtoFromCompany(Company c){
       var dto = new CompanyRegistrationDto();
       dto.setCity(c.getAddress().getCity());
       dto.setCnpj(c.getCnpj());
       dto.setComplement(c.getAddress().getComplement());
       dto.setName(c.getNome());
       dto.setStreet(c.getAddress().getStreet());
       dto.setNeighborhood(c.getAddress().getNeighborhood());
       dto.setNumber(c.getAddress().getNumber());
       dto.setState(c.getAddress().getState());
       return dto;
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


    /**
     * Atualiza os dados de uma entidade no banco de dados
     * @param comAllDto
     * @return retorna a entidade atualizada
     */

    public Company update(CompanyRegistrationDto comAllDto){
        var companyOptional = compAllRepo.findByCnpj(comAllDto.getCnpj());
        Company companyAll = null;
        if (companyOptional.isPresent()){
            companyAll = companyOptional.get();
            if(companyAll.getAddress().getCity() != comAllDto.getCity())
                companyAll.getAddress().setCity(comAllDto.getCity());
            if(companyAll.getAddress().getComplement() != comAllDto.getComplement())
                companyAll.getAddress().setComplement(comAllDto.getComplement());
            if(companyAll.getAddress().getNeighborhood() != comAllDto.getNeighborhood())
                companyAll.getAddress().setNeighborhood(comAllDto.getNeighborhood());
            if(companyAll.getAddress().getNumber() != comAllDto.getNumber())
                companyAll.getAddress().setNumber(comAllDto.getNumber());
            if(companyAll.getAddress().getState() != comAllDto.getCity())
                companyAll.getAddress().setState(comAllDto.getState());
            if(companyAll.getAddress().getStreet() != comAllDto.getStreet())
                companyAll.getAddress().setStreet(comAllDto.getStreet());
            compAllRepo.save(companyAll);
        }
        return companyAll;
    }

    /**
     * Encontra objeto no banco de dados com o mesmo id que foi passado, e o retorna.
     * @param companyId Cnpj da empresa a ser retornado
     * @return Objeto encontrado no banco de dados
     */

    public Optional<Company> ApagarPorId(Integer companyId){
        compAllRepo.deleteById(companyId);
        Optional<Company> companyD = compAllRepo.findById(companyId);
        return companyD;
    }
}
