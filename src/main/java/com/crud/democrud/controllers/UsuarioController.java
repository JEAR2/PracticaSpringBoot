package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }


    @PutMapping(path = "/{id}")
    public UsuarioModel editarUsuario(@PathVariable("id") Long id,@Validated @RequestBody UsuarioModel usuario){
        Optional<UsuarioModel> usuarioOptional = usuarioService.obtenerPorId(id);
        if(!usuarioOptional.isPresent()){
            return usuarioOptional.orElseThrow();
        }
        usuario.setId(usuarioOptional.get().getId());
        usuario.setEmail(usuarioOptional.get().getEmail());
        usuario.setPrioridad(usuarioOptional.get().getPrioridad());


        return usuarioService.guardarUsuario(usuario);

    }

/*
    @PutMapping("/usuario/{ib}")
    public UsuarioModel actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario){
        Optional<UsuarioModel> usuarioModelActual = usuarioService.obtenerPorId(id);
        ifusuarioModelActual.isPresent()
        return usuarioService.actualizarUsuario(usuario);
    }
*/
}