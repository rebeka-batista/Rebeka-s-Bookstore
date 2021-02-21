package br.com.bookstore.service;

import br.com.bookstore.entity.CompraEntity;
import br.com.bookstore.integration.model.Isbn;
import br.com.bookstore.integration.model.Item;
import br.com.bookstore.integration.model.LivroEntrada;
import br.com.bookstore.integration.service.LivroService;
import br.com.bookstore.mapper.CompraMapper;
import br.com.bookstore.model.CompraEntrada;
import br.com.bookstore.model.CompraSaida;
import br.com.bookstore.repository.CompraRepository;
import br.com.bookstore.validator.CompraValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    CompraRepository compraRepository;

    @Autowired
    CompraValidator compraValidator;

    @Autowired
    LivroService livroService;

    public CompraSaida save(CompraEntrada compraEntrada) {
        compraValidator.validarCompra(compraEntrada);
        CompraEntity compraEntity = CompraMapper.MAPPER.toEntity(compraEntrada);
        compraEntity.setPrecoTotal(getPrecoTotal(compraEntrada));
        compraEntity.setPreco(getAmount(compraEntrada));
        CompraSaida compraSaida = CompraMapper.MAPPER.toSaida(compraRepository.save(compraEntity));

        return compraSaida;
    }

    private BigDecimal getPrecoTotal(CompraEntrada compraEntrada) {
        LivroEntrada livroEntrada = livroService.encontrarIsbn(compraEntrada.getIsbn());
        for (Item item : livroEntrada.getItens()) {
            for (Isbn isbn : item.getVolumeInfo().getIsbns()) {
                if (isbn.getIsbn().equals(compraEntrada.getIsbn())) {
                    BigDecimal bigDecimal = BigDecimal
                            .valueOf(item.getSaleInfo().getListPrice().getValor()
                                    * compraEntrada.getQuantidade());
                    return bigDecimal.setScale(2, RoundingMode.HALF_UP);
                }
            }
        }
        return BigDecimal.valueOf(0.0);
    }

    private Double getAmount(CompraEntrada compraEntrada) {
        LivroEntrada livroEntrada = livroService.encontrarIsbn(compraEntrada.getIsbn());
        for (Item item : livroEntrada.getItens()) {
            for (Isbn isbn : item.getVolumeInfo().getIsbns()) {
                if (isbn.getIsbn().equals(compraEntrada.getIsbn())) {
                    return item.getSaleInfo().getListPrice().getValor();
                }
            }
        }
        return 0.0;
    }


    public List<CompraSaida> findAll() {
        Optional<List<CompraEntity>> optionalCompras = Optional.of(compraRepository.findAll());
        List<CompraSaida> compras = new ArrayList<>();
        if (optionalCompras.isPresent()) {
            for (CompraEntity c : optionalCompras.get()) {
                compras.add(CompraMapper.MAPPER.toSaida(c));
            }
        }
        return compras;
    }

    public CompraSaida findById(Integer idCompra) {
        Optional<CompraEntity> compras = compraRepository.findById(idCompra);
        if (compras.isPresent()) {
            return CompraMapper.MAPPER.toSaida(compras.get());
        }
        return null;
    }

}
