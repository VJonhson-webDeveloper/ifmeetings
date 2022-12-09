package br.edu.ifrn.teste.ifmeetings.controller.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrn.teste.ifmeetings.Dominio.Usuario;

@Controller
@RequestMapping("/usuarios")
public class CadastroUsuarioController {

    @GetMapping("/cadastro")
    public String entrarCadastro(ModelMap model) {

        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastro";
    }

    @ModelAttribute("estado")
    public List<String> getEstado() {
        return Arrays.asList("Amazônas", "Amapá", "Acre", "São Paulo", "Bahia", 
        "Rio de Janeiro", "Rio Grande do Norte", "Paraiba", "Pernambuco");
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/salvar")
    public String cadastrarUsuario(@Valid Usuario usuario, BindingResult resultadoAplicacao, RedirectAttributes attr, HttpSession memoria) {

        //verificando se os campos do formulario possuem algum erro
        if (resultadoAplicacao.hasErrors()) {
            return "redirect:/usuarios/cadastro";

        } else {
        //acessando dados da memória

        //Pegando último ID Cadastrado
        Integer id = (Integer) memoria.getAttribute("id");

        //Lista de Usuarios Já cadastrados na memoria
        List<Usuario> usuariosCadastrados = (List<Usuario>) memoria.getAttribute("usuariosCadastrados");

        if (id == null) {
            id = 1;
        }

        if (usuariosCadastrados == null) {
            usuariosCadastrados = new ArrayList<>();
        }

        //verifiando se é cadastro ou edição
        if (usuario.getId() == 0) {
        
            usuario.setId(id);
            usuariosCadastrados.add(usuario);

            id++;

            memoria.setAttribute("id", id);
            memoria.setAttribute("usuariosCadastrados", usuariosCadastrados);

            attr.addFlashAttribute("msgSucesso", "Inscrição realizada com sucesso, seja bem-vindo(a)!");

        } else {
            //é edição
            usuariosCadastrados.remove(usuario);
            usuariosCadastrados.add(usuario);

            attr.addFlashAttribute("msgSucesso", "Usuário editado com sucesso!");
        }

        return "redirect:/usuarios/cadastro";
        }
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") Integer idUsuario, ModelMap model, HttpSession memoria) {

        List<Usuario> usuariosCadastrados = (List<Usuario>) memoria.getAttribute("usuariosCadastrados");

        Usuario u = new Usuario();
        u.setId(idUsuario);

        int posicaoUsuarioLista = usuariosCadastrados.indexOf(u);
        u = usuariosCadastrados.get(posicaoUsuarioLista);

        model.addAttribute("usuario", u);

        return "usuario/cadastro";
    }
    
}
