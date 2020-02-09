package com.ifpb.interfacegrafica.dao;

import com.ifpb.interfacegrafica.modelo.Usuario;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UsuarioDaoSet {

    private Set<Usuario> usuarios;

    public UsuarioDaoSet(){
        usuarios = new HashSet<>();
    }

    public boolean salvar(Usuario usuario){
        return usuarios.add(usuario);
    }

    public Usuario buscarPorEmail(String email){
        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst().orElse(null);
    }

}
