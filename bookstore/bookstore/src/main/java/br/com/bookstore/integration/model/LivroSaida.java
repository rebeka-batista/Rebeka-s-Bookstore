package br.com.bookstore.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LivroSaida {

    @JsonProperty("isbn")
    private Integer isbn;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("autor")
    private String autor;

    @JsonProperty("sumario")
    private String sumario;

    @JsonProperty("preco")
    private double preco;

}
