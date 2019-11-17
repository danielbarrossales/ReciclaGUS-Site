package com.computeiros.reciclagus.repositories;

import com.computeiros.reciclagus.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer>
{
    @Async
    @Query("SELECT c FROM Company c where c.cnpj = ?1")
    Company findByCnpj(String cnpj);
}