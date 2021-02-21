package br.com.bookstore.validator;


import br.com.bookstore.integration.model.LivroEntrada;
import br.com.bookstore.integration.service.LivroService;
import br.com.bookstore.model.CompraEntrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class CompraValidator {
    public static final String ID_INVALIDO = "ID inválido!";
    public static final String ISBN_INVALIDO = "ISBN inválido";
    public static final String QUANTIDADE_INVALIDA = "Quantidade inválida";
    public static final String LIVRO_INVALIDO = "Livro inválido!";

    @Autowired
    LivroService livroService;

    public void validarCompra(CompraEntrada compraEntrada) {
        if (compraEntrada.getIdCliente() == null || compraEntrada.getIdCliente() <= 0) {
            throw new RuntimeException(ID_INVALIDO);
        }

        if (compraEntrada.getIsbn() == null || compraEntrada.getIsbn().isEmpty()) {
            throw new RuntimeException(ISBN_INVALIDO);
        }

        try {
            new BigInteger(compraEntrada.getIsbn());
        } catch (NumberFormatException e) {
            throw new RuntimeException(ISBN_INVALIDO);
        }

        LivroEntrada livroEntrada = livroService.encontrarIsbn(compraEntrada.getIsbn());
        if (livroEntrada == null) {
            throw new RuntimeException(LIVRO_INVALIDO);
        }

        if (livroEntrada.getItens() == null || livroEntrada.getItens().isEmpty()) {
            throw new RuntimeException(LIVRO_INVALIDO);
        }

        if (compraEntrada.getQuantidade() == null || compraEntrada.getQuantidade() <= 0) {
            throw new RuntimeException(QUANTIDADE_INVALIDA);
        }
    }
}
