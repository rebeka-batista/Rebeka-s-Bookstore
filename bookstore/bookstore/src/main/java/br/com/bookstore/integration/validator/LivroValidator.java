package br.com.bookstore.integration.validator;

import org.springframework.stereotype.Component;

@Component
public class LivroValidator {
    public static final String ISBN_INVALIDO = "ISBN inválido!";
    public static final String TITULO_INVALIDO = "Título inválido!";
    public static final String AUTOR_INVALIDO = "Autor inválido!";


    public void validarIsbn(Integer isbn) {
        if (isbn == null || isbn <= 0) {
            throw new RuntimeException(ISBN_INVALIDO);
        }
    }

    public void validarTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new RuntimeException(TITULO_INVALIDO);
        }
    }

    public void validarAutor(String autor) {
        if (autor == null || autor.isEmpty()) {
            throw new RuntimeException(AUTOR_INVALIDO);
        }
    }
}
