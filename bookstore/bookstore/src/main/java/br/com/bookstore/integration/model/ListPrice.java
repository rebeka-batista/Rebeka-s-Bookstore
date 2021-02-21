package br.com.bookstore.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListPrice {

    @JsonProperty("amount")
    private Double valor;

}
