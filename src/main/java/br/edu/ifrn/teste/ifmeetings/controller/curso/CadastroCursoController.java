package br.edu.ifrn.teste.ifmeetings.controller.curso;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.teste.ifmeetings.Dominio.Curso;

@Controller
@RequestMapping("/cursos")
public class CadastroCursoController {

    @GetMapping("/cadastro")
    public String acessarCadastroCurso(Model model) {

        model.addAttribute("curso", new Curso());

        return "curso/cadastro";
    }
}
