package br.com.bookstore.controller;

import br.com.bookstore.model.ClienteEntrada;
import br.com.bookstore.model.ClienteSaida;
import br.com.bookstore.repository.ClienteRepository;
import br.com.bookstore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ClienteSaida save(@RequestBody ClienteEntrada clienteEntrada) {
        return clienteService.save(clienteEntrada);
    }

    @GetMapping("/findbyid/{idCliente}")
    public ResponseEntity<ClienteSaida> findById(@PathVariable(name = "idCliente") Integer idCliente) {
        ClienteSaida clienteSaida = clienteService.findById(idCliente);
        if (clienteSaida == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity
                .ok()
                .body(clienteSaida);
    }

    @GetMapping("/find/all")
    public List<ClienteSaida> findAll() {
        return clienteService.findAll();
    }

    @DeleteMapping("/delete/{idCliente}")
    public String delete(@PathVariable(name = "idCliente") Integer idCliente) {
        return clienteService.delete(idCliente);
    }
}
