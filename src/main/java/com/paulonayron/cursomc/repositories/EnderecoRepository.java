package com.paulonayron.cursomc.repositories;

import com.paulonayron.cursomc.domain.Cidade;
import com.paulonayron.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
