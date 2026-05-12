package org.example.oscarapp.repository;

import org.example.oscarapp.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
    // Al extender JpaRepository, ya tenemos métodos creados de la otra clase
}