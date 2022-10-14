package br.edu.ifrn.teste.ifmeetings.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrn.teste.ifmeetings.Dominio.Usuario;

@Controller
@RequestMapping("/usuarios")
public class BuscaUsuarioController {
    
    @GetMapping("/busca")
    public String entrarBusca() {

        return "usuario/busca";
    }

    @GetMapping("/buscar")
    public String buscarUsuario(@RequestParam(name="nome", required = false) String nome, HttpSession memoria, ModelMap model) {

        //obtendo lista de usuarios cadastrados em memoria 
        List<Usuario> usuariosCadastrados = (List<Usuario>) memoria.getAttribute("usuariosCadastrados");
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        //se o usuario não digitou nada na busca 
        if (nome == null || nome.isEmpty()) {

            //então, será exibido todos os usuários cadastrados
            usuariosEncontrados = usuariosCadastrados;

        } else {
            //se o usuário digitou alguma coisa na busca...

            //primeiramente, verificando se há usuarios cadastrados 
            if (usuariosCadastrados != null) {
                
                //por fim, pegando da lista somente os usuarios com o nome digitado
                usuariosEncontrados = usuariosCadastrados.stream().filter(usuario -> usuario.getNome().toLowerCase().contains(nome.toLowerCase())).collect(Collectors.toList());
            }
        }

        model.addAttribute("usuariosEncontrados", usuariosEncontrados);

        return "usuario/busca";
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/remover/{id}")
    public String removerUsuario(@PathVariable("id") Integer idUsuario, HttpSession memoria, RedirectAttributes attr) {

        List<Usuario> usuariosCadastrados = (List<Usuario>) memoria.getAttribute("usuariosCadastrados");

        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);

        boolean removeu = usuariosCadastrados.remove(usuario);

        
        attr.addFlashAttribute("msgSucesso", "Usuário removido com sucesso!");
        

        return "redirect:/usuarios/buscar";
    }
}
