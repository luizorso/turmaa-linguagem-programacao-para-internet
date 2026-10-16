
package com.cepestm.turmaa.service;

import com.cepestm.turmaa.dto.UsuarioDTO;
import com.cepestm.turmaa.entity.Usuario;
import com.cepestm.turmaa.exception.ResourceNotFoundException;
import com.cepestm.turmaa.repository.UsuarioRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class UsuarioService {
    
    private final UsuarioRepository repository;
    
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }
    
    @Transactional
    public Usuario saveByDTO(UsuarioDTO dto){
        Usuario usuario = repository.save(dto.toUsuario());
        return usuario;
    }
    
    @Transactional(readOnly = true)
    public List<Usuario> listAll(){
        return repository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Usuario listById(UUID id){
       return repository.findById(id).orElseThrow(
               ()->
               new ResourceNotFoundException(
               "Usuário não encontrado para o ID:" + id)
       );
    }
    
    @Transactional
    public Usuario update(UUID id, UsuarioDTO dto){
        Usuario usuario = listById(id);
        usuario.setNome(dto.nome());
        usuario.setLogin(dto.login());
        usuario.setSenha(dto.senha());
        usuario.setEmail(dto.email());
        usuario.setStatus(dto.status());
        return repository.save(usuario);
    }
    
    @Transactional
    public void deleteById(UUID id){
        Usuario usuario = listById(id);
        repository.delete(usuario);
    }
    
    
    
}
