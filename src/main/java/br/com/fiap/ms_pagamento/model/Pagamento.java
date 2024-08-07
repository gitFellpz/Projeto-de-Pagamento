package br.com.fiap.ms_pagamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)       //Não pode ser nulo
    private BigDecimal valor;

    private String nome;            //nome do cartão
    private String numeroCartao;    //número do cartão
    private String validade;        //validade do cartão - MM/AA
    private String codigoSeguranca; //código de segurança do cartão - XXX

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;          //Status do pagamento

    @Column(nullable = false)
    private Long pedidoId;          //Id do pedido

    @Column(nullable = false)
    private Long formaPagamento;    //1 - dinheiro | 2 - cartão | 3 - pix

}
