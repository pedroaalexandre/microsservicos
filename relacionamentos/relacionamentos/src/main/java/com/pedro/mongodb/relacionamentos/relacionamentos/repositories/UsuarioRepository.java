package com.pedro.mongodb.relacionamentos.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.mongodb.relacionamentos.relacionamentos.models.Usuario;

public interface UsuarioRepository extends MongoRepository <Usuario, String> {  //<Classe, ID> -- Se o ID for String, Int...
    
}
