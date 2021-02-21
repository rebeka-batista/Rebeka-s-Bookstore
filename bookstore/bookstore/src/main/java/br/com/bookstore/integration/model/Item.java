package br.com.bookstore.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Item {

    @JsonProperty("volumeInfo")
    private VolumeInfo volumeInfo;

    @JsonProperty("saleInfo")
    private SaleInfo saleInfo;

}
