package com.pedro.mongodb.relacionamentos.relacionamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.mongodb.relacionamentos.relacionamentos.models.Perfil;
import com.pedro.mongodb.relacionamentos.relacionamentos.models.Usuario;
import com.pedro.mongodb.relacionamentos.relacionamentos.repositories.PerfilRepository;
import com.pedro.mongodb.relacionamentos.relacionamentos.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable("id") String id) {
        return usuarioRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {

        if(usuario.getPerfil() != null  && usuario.getPerfil().getId() == null) {
            Perfil perfilSalvo = perfilRepository.save(usuario.getPerfil());
            usuario.setPerfil(perfilSalvo);
        }
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario usuarioEditado) {
        
        Usuario usuario = usuarioRepository.findById(id)
                                                    .orElseThrow(() -> new RuntimeException());

        if(!usuarioEditado.getNome().equals(usuario.getNome())) {
            usuario.setNome(usuarioEditado.getNome());
        }
        if(!usuarioEditado.getPerfil().equals(usuario.getPerfil())) {
            usuario.setPerfil(usuarioEditado.getPerfil());
        }
        
        return usuarioRepository.save(usuario);
    }
    
    
}
