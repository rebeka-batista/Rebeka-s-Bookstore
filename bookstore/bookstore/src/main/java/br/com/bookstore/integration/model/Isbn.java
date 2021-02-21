package br.com.bookstore.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Isbn {

    @JsonProperty("identifier")
    private String isbn;

    @JsonProperty("type")
    private String tipoIsbn;

}
