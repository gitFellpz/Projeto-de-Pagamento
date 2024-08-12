package br.com.fiap.ms_pagamento.dto;

import br.com.fiap.ms_pagamento.model.Pagamento;
import br.com.fiap.ms_pagamento.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class PagamentoDTO {
    private long id;

    @NotNull(message = "Campo obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valor;

    @Size(max = 100, message = "Máximo de 100 caracteres")
    private String nome;

    @Size(max = 19, message = "Número do cartão deve ter no máximo 19 caracteres")
    private String numeroCartao;

    @Size(min = 5, max = 5, message = "Validade deve ter 5 caracteres (mm/aa)")
    private String validade;

    @Size(min = 3, max = 3, message = "Código de segurança deve ter 3 caracteres")
    private String codigoSeguranca;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @NotNull(message = "Pedido ID é obrigatório")
    private long pedidoId;

    @NotNull(message = "Forma de pagamento é obrigatória")
    private long idformaPagamento;

    public PagamentoDTO (Pagamento entity) {
        id = entity.getId();
        valor = entity.getValor();
        nome = entity.getNome();
        numeroCartao = entity.getNumeroCartao();
        codigoSeguranca = entity.getCodigoSeguranca();
        status = entity.getStatus();
        pedidoId = entity.getPedidoId();
        idformaPagamento = entity.getFormaPagamento();
    }

}
