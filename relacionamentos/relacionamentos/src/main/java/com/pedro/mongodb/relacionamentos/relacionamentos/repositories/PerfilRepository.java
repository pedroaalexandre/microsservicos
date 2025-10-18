package com.pedro.mongodb.relacionamentos.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.mongodb.relacionamentos.relacionamentos.models.Perfil;

public interface PerfilRepository extends MongoRepository <Perfil, String> {    //<Classe, ID> -- Se o ID for String, Int...

}
