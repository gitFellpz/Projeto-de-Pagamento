package br.com.fiap.ms_pagamento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Pagamento {

    private long id;
    private BigDecimal valor;
    private String nome;            //nome do cartão
    private String numeroCartao;    //número do cartão
    private String validade;        //validade do cartão - MM/AA
    private String codigoSeguranca; //código de segurança do cartão - XXX
    private Status status;          //Status do pagamento
    private Long pedidoId;          //Id do pedido
    private Long formaPagamento;    //1 - dinheiro | 2 - cartão | 3 - pix

}
