package com.example.aula1.dto;


public class PedidoCreateDTO {
    
    private String descricao;
    private Double valor;
    



    public PedidoCreateDTO() {}


    public PedidoCreateDTO(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
       
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }




}
