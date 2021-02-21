package br.com.bookstore.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SaleInfo {

    @JsonProperty("listPrice")
    private ListPrice listPrice;

}
