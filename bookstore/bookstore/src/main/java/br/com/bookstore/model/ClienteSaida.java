package br.com.bookstore.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteSaida {

    @JsonProperty("id_cliente")
    private Integer idCliente;

    @JsonProperty("nome_completo")
    private String nomeCompleto;
}
