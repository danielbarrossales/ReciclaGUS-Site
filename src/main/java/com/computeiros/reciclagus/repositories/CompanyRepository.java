package com.computeiros.reciclagus.repositories;

import com.computeiros.reciclagus.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer>
{

}