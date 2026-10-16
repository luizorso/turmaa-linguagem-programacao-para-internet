
package com.cepestm.turmaa.dto;

import com.cepestm.turmaa.entity.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;


public record PerfilDTO(
    UUID id,
    @NotBlank(message = "O nome é obrigatório")
    @Size(min= 8, max= 100, message="O nome deve ter entre 8 e 100 caracteres")
    String nome){
    
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
