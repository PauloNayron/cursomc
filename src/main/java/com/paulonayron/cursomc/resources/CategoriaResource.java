package com.paulonayron.cursomc.resources;

import com.paulonayron.cursomc.domain.Categoria;
import com.paulonayron.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<?> insert (@RequestBody Categoria categoria) {
        Categoria categoriaSalva =  service.insert(categoria);
        return ResponseEntity.ok().body(categoriaSalva);
    }
}
