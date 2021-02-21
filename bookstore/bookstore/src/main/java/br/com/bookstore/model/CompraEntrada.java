package br.com.bookstore.model;


import br.com.bookstore.pagamento.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompraEntrada {

    @JsonProperty("id_cliente")
    private Integer idCliente;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("forma_pagamento")
    private FormaPagamento formaDePagamento;

    @JsonProperty("quantidade")
    private Integer quantidade;
}
