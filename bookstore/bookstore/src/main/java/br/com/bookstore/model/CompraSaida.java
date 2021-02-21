package br.com.bookstore.model;

import br.com.bookstore.pagamento.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CompraSaida {

    @JsonProperty("id_compra")
    private Integer idCompra;

    @JsonProperty("id_cliente")
    private Integer idCliente;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("preco")
    private Double preco;

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("preco_total")
    private BigDecimal precoTotal;

    @JsonProperty("forma_pagamento")
    private FormaPagamento formaDePagamento;

}
