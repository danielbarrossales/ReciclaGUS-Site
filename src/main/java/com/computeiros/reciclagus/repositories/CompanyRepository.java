package com.computeiros.reciclagus.repositories;

import com.computeiros.reciclagus.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Empresa, Integer>
{

}