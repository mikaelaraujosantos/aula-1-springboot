package com.example.aula1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula1.Usuario;




@RestController
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    int contador = 1;
    @PostMapping("/usuario")
    public String saudacao(@RequestBody Usuario usuario) {
        usuario.setId(contador);
        contador ++;
        usuarios.add(usuario);
       
        return "Usuário " + usuario.getNome() + " criado com sucesso!";
    }





    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
   




    @GetMapping("/usuario/{id}")
    public Usuario id(@PathVariable long id ){

        for(Usuario u : usuarios){
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    

    
    
    
}

/* 
RestController é uma anotação do Spring que indica que a classe é um controlador Rest.
GetMapping é um mapeador de requisições HTTP GET para o método hello.
PostMapping é um mapeador de requisições HTTP POST para o método saudacao.
RequestBody é uma anotação que indica que o parâmetro do método deve ser preenchido com o corpo da requisição HTTP, que é convertido para um objeto Usuario.

 */
