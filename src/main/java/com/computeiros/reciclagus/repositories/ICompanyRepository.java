package com.computeiros.reciclagus.repositories;

import com.computeiros.reciclagus.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Integer>
{

}