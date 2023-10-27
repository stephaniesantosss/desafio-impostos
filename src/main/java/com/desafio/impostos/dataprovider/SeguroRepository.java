package com.desafio.impostos.dataprovider;

import com.desafio.impostos.core.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, String> {
    Optional<Seguro> findByCategoria(String categoria);
}
