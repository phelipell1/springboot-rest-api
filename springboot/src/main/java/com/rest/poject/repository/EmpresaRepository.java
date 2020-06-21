package com.rest.poject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.poject.model.Empresas;

public interface EmpresaRepository extends JpaRepository<Empresas, Long> {

}
