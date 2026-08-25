
package com.cepestm.turmaa.controller;

import com.cepestm.turmaa.dto.PerfilDTO;
import com.cepestm.turmaa.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController{
    
    @Autowired
    private PerfilService service;
    
    @GetMapping("/cadastrarPerfil")
    public String cadastrarPerfil(Model model){
        model.addAttribute("título", "Cadastro de Perfil");
        model.addAttribute("perfilDTO", new PerfilDTO(""));
        return "cadastrarPerfil";
        
    }
    
}
