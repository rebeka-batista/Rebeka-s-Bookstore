package br.com.bookstore.integration.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class LivroEntrada {

    @JsonProperty("items")
    private List<Item> itens;

}
