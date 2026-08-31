
package com.cepestm.turmaa.service;

import com.cepestm.turmaa.dto.PerfilDTO;
import com.cepestm.turmaa.entity.Perfil;
import com.cepestm.turmaa.repository.PerfilRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
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
    
    public List<Perfil> listAll(){
        return rep.findAll();
    }
     /*
        findById(id)> retorna um objeto do tipo optional <Perfil>.
        Usamos .orElseThrow para lançar uma exceção amigável
        caso o Id buscado não exista no banco de dados.
    */
    
    
    public Perfil listById(UUID id){
        return rep.findById(id)
        .orElseThrow(() ->  new RuntimeException(
                "Perfil não encontrado para o ID: " +  id));
    }
    
    @Transactional
    public void deleteById(UUID id){
        //Declar um objeto perfil e atribui a ele um perfil
        //pelo métodoListByIdm
        Perfil perfil = listById(id);
        //O objeto rep invoca o método delete e passa 
        //como parâmetro o perfil
        rep.delete(perfil);
    }
    
    @Transactional
    public Perfil update(UUID id, PerfilDTO dto){
        //Busca o perfil existen no banco de dado
        Perfil perfil = listById(id);
        
        //Atualiza os dados da entidade com as informações
        //recebido no objeto DTO
        perfil.setNome(dto.nome());
        
        //Salva a entidade atualizada (faz Update por conta do Id presente)
        return rep.save(perfil);
    }
    
}
