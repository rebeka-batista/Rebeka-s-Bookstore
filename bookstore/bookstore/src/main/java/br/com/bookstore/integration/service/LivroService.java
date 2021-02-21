package br.com.bookstore.integration.service;


import br.com.bookstore.integration.client.LivroClient;
import br.com.bookstore.integration.model.LivroEntrada;
import br.com.bookstore.integration.validator.LivroValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroValidator livroValidator;

    @Autowired
    private LivroClient livroClient;

    public LivroEntrada encontrarIsbn(String isbn) {
        String queryParam = "isbn:{numero}";
        queryParam = queryParam.replace("{numero}", isbn);
        return livroClient.getLivroEntradaByIsbn(isbn);
    }
}