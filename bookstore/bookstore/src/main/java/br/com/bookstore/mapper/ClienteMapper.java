package br.com.bookstore.mapper;


import br.com.bookstore.entity.ClienteEntity;
import br.com.bookstore.model.ClienteEntrada;
import br.com.bookstore.model.ClienteSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper MAPPER = Mappers.getMapper(ClienteMapper.class);
    ClienteEntity toEntity(ClienteEntrada clienteEntrada);
    ClienteSaida toSaida(ClienteEntity clienteEntity);

}
