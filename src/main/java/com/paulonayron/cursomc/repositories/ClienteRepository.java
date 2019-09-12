package com.paulonayron.cursomc.repositories;

import com.paulonayron.cursomc.domain.Categoria;
import com.paulonayron.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
