package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario/rol")
public class UsuarioRolController {
    @Autowired
    private UsuarioRolService usuarioRolService;

    @GetMapping()
    public ArrayList<UsuarioRolModel> obtenerUsuarioRol() {
        return usuarioRolService.obtenerUsuarioRol();
    }


}
