package br.com.bookstore.service;


import br.com.bookstore.entity.ClienteEntity;
import br.com.bookstore.mapper.ClienteMapper;
import br.com.bookstore.model.ClienteEntrada;
import br.com.bookstore.model.ClienteSaida;
import br.com.bookstore.repository.ClienteRepository;
import br.com.bookstore.validator.ClienteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    public static final String ID_INVALIDO = "ID inválido!";

    @Autowired
    ClienteValidator clienteValidator;

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteSaida save(ClienteEntrada clienteEntrada) {
        clienteValidator.validarCliente(clienteEntrada);
        ClienteEntity clienteEntity = ClienteMapper.MAPPER.toEntity(clienteEntrada);
        return ClienteMapper.MAPPER.toSaida(clienteRepository.save(clienteEntity));
    }

    public List<ClienteSaida> findAll() {
        Optional<List<ClienteEntity>> optionalClientes = Optional.of(clienteRepository.findAll());
        List<ClienteSaida> clientes = new ArrayList<>();
        if (optionalClientes.isPresent()) {
            for (ClienteEntity c : optionalClientes.get()) {
                clientes.add(ClienteMapper.MAPPER.toSaida(c));
            }
        }
        return clientes;
    }

    public ClienteSaida findById(Integer idCliente) {
        Optional<ClienteEntity> clientes = clienteRepository.findById(idCliente);
        if (clientes.isPresent()) {
            return ClienteMapper.MAPPER.toSaida(clientes.get());
        }
        return null;
    }

    public String delete(Integer idCliente) {
        if (idCliente <= 0 || idCliente == null) {
            throw new RuntimeException(ID_INVALIDO);
        }
        try {
            clienteRepository.deleteById(idCliente);

        } catch (IllegalArgumentException e) {
            System.out.println("Falha ao deletar!");
            return "Falha ao deletar!";
        } catch (DataAccessException e) {
            System.out.println("Id inválido!");
            return "Id inválido!";
        }
        System.out.println("Sucesso ao deletar");
        return "Sucesso ao deletar!";
    }
}
