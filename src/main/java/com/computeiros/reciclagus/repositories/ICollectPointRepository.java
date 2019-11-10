package com.computeiros.reciclagus.repositories;

import com.computeiros.reciclagus.entities.CollectPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICollectPointRepository extends JpaRepository<CollectPoint, Integer> {
}
