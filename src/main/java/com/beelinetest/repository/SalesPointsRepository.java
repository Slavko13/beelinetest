package com.beelinetest.repository;

import com.beelinetest.entity.SalesPoints;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalesPointsRepository extends CrudRepository<SalesPoints, Integer> {
    List<SalesPoints> findAllByCity(String city);
}
