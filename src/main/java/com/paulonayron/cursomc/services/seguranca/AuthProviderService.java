package com.paulonayron.cursomc.services.seguranca;

import com.paulonayron.cursomc.domain.Usuario;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProviderService implements AuthenticationProvider {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String senha = authentication.getCredentials().toString();

        Usuario usuarioBd = usuarioService.getUsuarioByCpf(login);
        if (!usuarioBd.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha incorreta.");
        }

        if (usuarioBd != null) {
            if (usuarioAtivo(usuarioBd)) {
                Collection<? extends GrantedAuthority> authorities = usuarioBd.getPapeis();
                return new UsernamePasswordAuthenticationToken(login, senha, authorities);
            } else {
                throw new BadCredentialsException("Este usuário está desativado.");
            }
        }
        throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean usuarioAtivo(Usuario usuario) {
        if (usuario != null) {
            if (usuario.getStatus() == true) {
                return true;
            }
        }
        return false;
    }
}
