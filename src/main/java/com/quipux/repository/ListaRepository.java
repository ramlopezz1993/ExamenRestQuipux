package com.quipux.repository;

import com.quipux.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
    Lista findByTitulo (String titulo);
    Lista findById (int id);
}
