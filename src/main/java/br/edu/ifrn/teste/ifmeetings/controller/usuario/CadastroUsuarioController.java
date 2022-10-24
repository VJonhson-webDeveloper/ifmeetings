package br.edu.ifrn.teste.ifmeetings.controller.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String cadastrarUsuario(Usuario usuario, RedirectAttributes attr, HttpSession memoria) {

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

        usuario.setId(id);
        usuariosCadastrados.add(usuario);

        id++;

        memoria.setAttribute("id", id);
        memoria.setAttribute("usuariosCadastrados", usuariosCadastrados);

        attr.addFlashAttribute("msgSucesso", "Inscrição realizada com sucesso, seja bem-vindo(a)!");

        return "redirect:/usuarios/cadastro";
    }
    
}
