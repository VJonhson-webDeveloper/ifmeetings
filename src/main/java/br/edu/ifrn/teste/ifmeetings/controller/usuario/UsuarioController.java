package br.edu.ifrn.teste.ifmeetings.controller.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }   
}