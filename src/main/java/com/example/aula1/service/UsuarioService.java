package com.example.aula1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aula1.model.UsuarioModel;

@Service
public class UsuarioService {
    private List<UsuarioModel> usuarios = new ArrayList<>();
    private long contador = 1;

    public String criarUsuario(UsuarioModel usuario){
        usuario.setId(contador);
        contador++;
        usuarios.add(usuario);
        return "Usuario"+usuario.getNome()+"criado com sucesso";
    }


    public List<UsuarioModel> listarUsuarios() {
        return usuarios;
    }


    public UsuarioModel buscarPorid(long id) {
        for(UsuarioModel u : usuarios){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }


    public String removerUsuario(long id){
        boolean resultado = usuarios.removeIf(u -> u.getId() == id);
        if (resultado){
            return "Usuario removido com sucesso";
        }else{
            return "Usuario nao encontrado";
        }
    }

        public String atualizaUsuario(long id , UsuarioModel usuario_atualizado){

            for (UsuarioModel u : usuarios){
                if (u.getId() == id){
                    u.setNome(usuario_atualizado.getNome());
                    u.setIdade(usuario_atualizado.getIdade());
                    return "Usuario atualizado com sucesso!!";
                }
            }
            return"Usuario nao encontrado";
        }





    
}
