package br.com.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteEntrada {

    @JsonProperty("nome_completo")
    private String nomeCompleto;

}
