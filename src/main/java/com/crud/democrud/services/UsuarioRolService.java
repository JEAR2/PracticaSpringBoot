package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class UsuarioRolService {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    public ArrayList<UsuarioRolModel> obtenerUsuarioRol(){return (ArrayList<UsuarioRolModel>) usuarioRolRepository.findAll();}

}
