package com.quipux.repository;

import com.quipux.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer> {
    List<Cancion> findByListaId (Integer id);
}
