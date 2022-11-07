package br.edu.ifrn.teste.ifmeetings.controller.curso;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrn.teste.ifmeetings.Dominio.Curso;

@Controller
@RequestMapping("/cursos")
public class BuscaCursoController {
    
    @SuppressWarnings("unchecked")
    @GetMapping("/listar")
    public String listarCursos(HttpSession memoria, ModelMap model) {

        List<Curso> cursosCadastrados = (List<Curso>) memoria.getAttribute("cursosCadastrados");
        List<Curso> cursosEncontrados = new ArrayList<>();

        if (cursosCadastrados != null) {
            cursosEncontrados = cursosCadastrados;
        }

        model.addAttribute("cursosEncontrados", cursosEncontrados);

        return "curso/listaCursos";
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/remover/{idCurso}")
    public String removerCurso(@PathVariable("idCurso") Integer idCurso, HttpSession memoria, RedirectAttributes attr){

        List<Curso> cursosCadastrados = (List<Curso>) memoria.getAttribute("cursosCadastados");

        Curso c = new Curso();
        c.setIdCurso(idCurso);

        cursosCadastrados.remove(c);

        attr.addFlashAttribute("mgsSucesso", "Curso removido com sucesso!");

        return "redirect:/cursos/listar";
    }
}
