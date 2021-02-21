package br.com.bookstore.mapper;

import br.com.bookstore.entity.CompraEntity;
import br.com.bookstore.model.CompraEntrada;
import br.com.bookstore.model.CompraSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompraMapper {
    CompraMapper MAPPER = Mappers.getMapper(CompraMapper.class);

    CompraEntity toEntity(CompraEntrada compraEntrada);
    CompraSaida toSaida(CompraEntity compraEntity);

}
