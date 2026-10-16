
package com.cepestm.turmaa.dto;

import com.cepestm.turmaa.entity.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public record UsuarioDTO(
    UUID id,
    @NotBlank(message="O nome é obrigatório!")
    @Size(min = 8, max = 100, message="O nome deve ter entre 3 e 100 caracteres")
    String nome,
    @NotBlank(message="O login é obrigatório")
    @Size(min= 8, max = 16, message = "A senha deve ter no mínimo 6 caracteres")
    String login,
    @NotBlank(message="A senha é obrigatória")
    @Size(min= 8, max = 128)
    String senha,
    @NotBlank(message="O email é obrigatório")
    @Email(message = "informe um e-mail válido")
    String email,
    boolean status
        
        
        ) {
    
        //Construtor utilitário para cadastrar novos usuarios sem o ID
    public UsuarioDTO(String nome, String login, String senha,
            String email, boolean status){
        this(null, nome, login, senha, email, status);
        
    }
    
    //Construtor utilitário para cadastrar novos usuarios sem o ID
    
    public UsuarioDTO(Usuario usuario){
        this(
        usuario.getId(),
        usuario.getNome(),
        usuario.getLogin(),
        usuario.getSenha(),
        usuario.getEmail(),
        usuario.isStatus()
    );
    }
        
        
    public Usuario toUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(this.id());
        usuario.setNome(this.nome());
        usuario.setLogin(this.login());
        usuario.setSenha(this.senha());
        usuario.setEmail(this.email());
        usuario.setStatus(this.status());
        return usuario;
        
    }
        
    }
    
    



