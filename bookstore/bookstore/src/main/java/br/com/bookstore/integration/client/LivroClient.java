package br.com.bookstore.integration.client;


import br.com.bookstore.integration.model.LivroEntrada;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "livros", url = "${rota.livro}")
public interface LivroClient {

    @GetMapping
    LivroEntrada getLivroEntradaByIsbn(@RequestParam(name = "q") String isbn);
}