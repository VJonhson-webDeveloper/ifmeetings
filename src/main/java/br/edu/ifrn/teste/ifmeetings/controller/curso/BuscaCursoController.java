package br.edu.ifrn.teste.ifmeetings.controller.curso;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrn.teste.ifmeetings.Dominio.Curso;

@Controller
@RequestMapping("/cursos")
public class BuscaCursoController {
    
    @SuppressWarnings("unchecked")
    @GetMapping("/listar")
    public String listarCursos(HttpSession memoria, ModelMap model) {

        List<Curso> cursosCadastrados = (List<Curso>) memoria.getAttribute("cursosCadastrados");

        model.addAttribute("cursosCadastrados", cursosCadastrados);

        return "curso/listar";
        }
}
