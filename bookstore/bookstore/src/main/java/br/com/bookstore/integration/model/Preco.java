package br.com.bookstore.integration.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Preco {

    @JsonProperty("currency")
    private Double moeda;

    @JsonProperty("displayValue")
    private Double displayValue;

}
