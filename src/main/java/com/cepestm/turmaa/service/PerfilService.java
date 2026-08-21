
package com.cepestm.turmaa.service;

import com.cepestm.turmaa.dto.PerfilDTO;
import com.cepestm.turmaa.entity.Perfil;
import com.cepestm.turmaa.repository.PerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    
   
    private final PerfilRepository rep;
    
    public PerfilService(PerfilRepository rep){
        this.rep = rep;
    }
    
    //Converte o objeto perfilDTO em um objeto da entidade perfil
    @Transactional
    public Perfil saveByDTO(PerfilDTO dto){
        // executa o insert na base dados
        Perfil perfil = rep.save(dto.toPerfil());
        return perfil;
    }
    
}
