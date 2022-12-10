package br.edu.ifrn.teste.ifmeetings.controller.curso;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrn.teste.ifmeetings.Dominio.Curso;

@Controller
@RequestMapping("/cursos")
public class CadastroCursoController {

    @GetMapping("/cadastro")
    public String acessarCadastroCurso(Model model) {

        model.addAttribute("curso", new Curso());

        return "curso/cadastro";
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/cadastrar")
    public String cadastrarCurso(@Valid Curso curso, BindingResult result, RedirectAttributes attr, HttpSession memoria) {

        //verificando se há algum erro nos inputs do formulário de cadastro dos cursos
        if (result.hasErrors()) {
            return "curso/cadastro";
        }

        //acessando dados da memória 

        //pegando o último id de Curso cadastrado
        Integer idCurso = (Integer) memoria.getAttribute("idCurso");

        //Criando lista de cursos já cadastrados na memória
        List<Curso> cursosCadastrados = (List<Curso>) memoria.getAttribute("cursosCadastrados");

        //se o id do Curso for igual a null (o), então iremos cadastrar o primeiro curso
        //por isso ele receberá o id = 1
        if (idCurso == null) {
            idCurso = 1;
        }

        //se não houver nenhum curso cadastrado teremos que criar uma nova lista de cursos cadastrados para armazena-los
        if (cursosCadastrados == null) {
            cursosCadastrados = new ArrayList<>();
        }

        //após as verificações

        if (curso.getIdCurso() == 0) {

            //salvando o id do curso cadastrado e adiciona-o na lista de cursos cadastrados
            curso.setIdCurso(idCurso);
            cursosCadastrados.add(curso);
            idCurso++;

            memoria.setAttribute("idCurso", idCurso);
            memoria.setAttribute("cursosCadastrados", cursosCadastrados);
      
            //enviando mensagem de sucesso
            attr.addFlashAttribute("msgSucesso", "Curso cadastrado com sucesso!");

        } else {

            //é edição
            cursosCadastrados.remove(curso);
            cursosCadastrados.add(curso);
            attr.addFlashAttribute("msgSucesso", "Curso editado com sucesso!");
        }
        
        return "redirect:/cursos/cadastro";
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/editar/{idCurso}")
    public String editarCurso(@PathVariable("idCurso") Integer idCurso, ModelMap model, HttpSession memoria) {

        List<Curso> cursosCadastrados = (List<Curso>) memoria.getAttribute("cursosCadastrados");

        Curso c = new Curso();
        c.setIdCurso(idCurso);

        int posicaoCursoLista = cursosCadastrados.indexOf(c);
        c = cursosCadastrados.get(posicaoCursoLista);

        model.addAttribute("curso", c);

        return "/curso/cadastro";
    }
}
