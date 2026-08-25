
package com.cepestm.turmaa.dto;

import com.cepestm.turmaa.entity.*;
import java.util.UUID;


public record PerfilDTO(UUID id,String nome){
    
    public PerfilDTO(String nome){
        this(null, nome);
    }
    
    public Perfil toPerfil(){
        Perfil perfil = new Perfil();
        perfil.setId(id);
        perfil.setNome(nome);
        return perfil;
        
    }
    
}
