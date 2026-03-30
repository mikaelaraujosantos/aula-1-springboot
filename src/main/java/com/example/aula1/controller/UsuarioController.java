package com.example.aula1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula1.model.UsuarioModel;
import com.example.aula1.service.UsuarioService;

import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @PostMapping("/usuario")
    public String saudacao(@RequestBody UsuarioModel usuario) {
        return service.criarUsuario(usuario);
    }


    @GetMapping("/usuarios")
    public List<UsuarioModel> listarUsuarios() {
        return service.listarUsuarios();
    }


    @GetMapping("/usuario/{id}")
    public UsuarioModel id(@PathVariable long id ){

        return service.buscarPorid(id);
    }


    @DeleteMapping("/usuario/{id}")
    public String removerUsuariuID(@PathVariable long id){

       return service.removerUsuario(id);
    }


    @PutMapping("/usuario/{id}")
    public String atualizarUsuarioId(@PathVariable long id, @RequestBody UsuarioModel usuario_atualizado) {
                  
        return service.atualizaUsuario(id, usuario_atualizado);
     }
    
}
 

/* 
RestController é uma anotação do Spring que indica que a classe é um controlador Rest.
GetMapping é um mapeador de requisições HTTP GET para o método hello.
PostMapping é um mapeador de requisições HTTP POST para o método saudacao.
RequestBody é uma anotação que indica que o parâmetro do método deve ser preenchido com o corpo da requisição HTTP, que é convertido para um objeto Usuario.

 */
