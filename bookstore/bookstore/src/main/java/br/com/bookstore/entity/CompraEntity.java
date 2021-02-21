package br.com.bookstore.entity;


import br.com.bookstore.pagamento.FormaPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "compras")
@Data
@NoArgsConstructor
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Transient
    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "forma_pagamento")
    private FormaPagamento formaDePagamento;

    @Column(name = "preco_total", scale = 2, precision = 10)
    private BigDecimal precoTotal;
}
