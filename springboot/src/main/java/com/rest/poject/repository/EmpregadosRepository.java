package com.rest.poject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.poject.model.Empregados;

@Repository
public interface EmpregadosRepository extends JpaRepository<Empregados, Long>{

}
