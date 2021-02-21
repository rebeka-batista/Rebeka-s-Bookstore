package br.com.bookstore.validator;


import br.com.bookstore.model.ClienteEntrada;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator {
    public static final String NOME_INVALIDO = "Nome inválido!";

    public void validarCliente(ClienteEntrada clienteEntrada) {
        if (clienteEntrada.getNomeCompleto() == null || clienteEntrada.getNomeCompleto().isEmpty()) {
            throw new RuntimeException(NOME_INVALIDO);
        }
    }
}
