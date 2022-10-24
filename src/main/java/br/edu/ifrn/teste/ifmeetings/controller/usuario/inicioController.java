package br.edu.ifrn.teste.ifmeetings.controller.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inicioController {
    
    @GetMapping("/ifmeetings")
    public String inicio() {
        return "index";
    }

}
