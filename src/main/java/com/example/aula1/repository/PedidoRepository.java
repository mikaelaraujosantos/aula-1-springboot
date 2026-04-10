package com.example.aula1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aula1.model.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long>{
    

    List<PedidoModel> findByUsuarioId(Long usuarioId);
}
