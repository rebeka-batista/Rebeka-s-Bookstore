package br.com.bookstore.pagamento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormaPagamento {
    CREDITO, DEBITO;
}
