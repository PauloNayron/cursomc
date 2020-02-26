package com.paulonayron.cursomc.resources;

import com.paulonayron.cursomc.domain.Categoria;
import com.paulonayron.cursomc.services.CategoriaService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nome;
        if (principal instanceof UserDetails) {
            nome = ((UserDetails)principal).getUsername();
        } else {
            nome = principal.toString();
        }
        System.out.printf("Usuário Logado" + nome);

        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<?> insert (@RequestBody Categoria categoria) {
        Categoria categoriaSalva =  service.insert(categoria);
        return ResponseEntity.ok().body(categoriaSalva);
    }
}
