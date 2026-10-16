
package com.cepestm.turmaa.repository;

import com.cepestm.turmaa.entity.Usuario;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
}
