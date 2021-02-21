package br.com.bookstore.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VolumeInfo {

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("industryIdentifiers")
    private List<Isbn> isbns;

    @JsonProperty("authors")
    private String[] autores;

}
