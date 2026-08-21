
package com.cepestm.turmaa.repository;

import com.cepestm.turmaa.entity.Perfil;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository 
        extends JpaRepository<Perfil, UUID>{
   
    
    
}
