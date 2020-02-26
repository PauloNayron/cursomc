package com.paulonayron.cursomc.services.seguranca;

import com.paulonayron.cursomc.domain.Usuario;
import com.paulonayron.cursomc.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioByCpf(String cpf) {
        return usuarioRepository.findByLogin(cpf);
    }

}
