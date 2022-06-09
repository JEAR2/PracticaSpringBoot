package com.crud.democrud.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private Set<UsuarioRolModel> rol = new HashSet<>();

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioModel(String nombre, String email, Integer prioridad) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }

    public UsuarioModel() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UsuarioRolModel> getRol() {
        return rol;
    }

    public void setRol(Set<UsuarioRolModel> rol) {
        this.rol = rol;
        for (UsuarioRolModel UsuRol: rol){
            UsuRol.setUsuario(this);
        }
    }
}