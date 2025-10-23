package com.clinica_veterinaria.clinica_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica_veterinaria.clinica_veterinaria.models.Dueno;

@Repository
public interface IDuenoRepository extends JpaRepository<Dueno,Long> {

}
