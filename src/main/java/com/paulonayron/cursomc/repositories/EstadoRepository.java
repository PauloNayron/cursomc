package com.paulonayron.cursomc.repositories;

import com.paulonayron.cursomc.domain.Cidade;
import com.paulonayron.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
