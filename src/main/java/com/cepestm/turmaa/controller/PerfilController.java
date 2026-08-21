
package com.cepestm.turmaa.controller;

import com.cepestm.turmaa.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PerfilController {
    
    @Autowired
    private PerfilService service;
    
}
