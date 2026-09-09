
package com.cepestm.turmaa.controller;

import com.cepestm.turmaa.dto.PerfilDTO;
import com.cepestm.turmaa.entity.Perfil;
import com.cepestm.turmaa.service.PerfilService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PerfilController{
    
   private final PerfilService service;
   
   public PerfilController(PerfilService service){
       this.service = service;
   }
    
    @GetMapping("/cadastrarPerfil")
    public String cadastrarPerfil(Model model){
        model.addAttribute("titulo", "Cadastro de Perfil");
        model.addAttribute("perfilDTO", new PerfilDTO(""));
        return "cadastrarPerfil";
        
    }
    
    @PostMapping("/cadastrarPerfil")
    public String salvarPerfil(@ModelAttribute("perfilDTO")
                PerfilDTO dto,
                RedirectAttributes redAtributos){
        if(dto.id() != null){
            service.update(dto.id(), dto);
            redAtributos.addFlashAttribute(
                 "mensagem","Perfil atualizado com sucesso!");
        }else{
            service.saveByDTO(dto);
            redAtributos.addFlashAttribute(
                 "mensagem", "Perfil cadastrado com sucesso!"
            );
        }
        return "redirect:/perfis";
    }
    @GetMapping("/perfis")
    public String listarPerfis(Model model){
        //Busca todos os perfis através do serviço
        List<Perfil> perfis = service.listAll();
        /*Adiciona a lista perfis ao model para poder
        ficar acessível para o thymeleaf
        */
        model.addAttribute("perfis", perfis);
        //Retorna  a página html chamada listarPerfis.html
        return "listarPerfis";
    }
    
    
      @PostMapping("/perfis/excluir/{id}")
    public String excluirPerfil(@PathVariable("id") UUID id,
           RedirectAttributes redAtributos){
        service.deleteById(id);
        redAtributos.addFlashAttribute("mensagem", 
                "Perfil excluído com sucesso!");
        return "redirect:/perfis";
        
    }
  }
    

