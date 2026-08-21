
package com.cepestm.turmaa.dto;

import com.cepestm.turmaa.entity.Perfil;


public record PerfilDTO(String nome) {
    
    public Perfil toPerfil(){
        Perfil perfil = new Perfil();
        perfil.setNome(nome);
        return perfil;
    }
    
}
