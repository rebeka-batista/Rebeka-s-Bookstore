package br.com.bookstore.controller;


import br.com.bookstore.model.CompraEntrada;
import br.com.bookstore.model.CompraSaida;
import br.com.bookstore.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraService compraService;

    @PostMapping
    public CompraSaida save(@RequestBody CompraEntrada compraEntrada) {
        return compraService.save(compraEntrada);
    }


    @GetMapping("/findbyid/{idCompra}")
    public ResponseEntity<CompraSaida> findById(@PathVariable(name = "idCompra") Integer idCompra) {
        CompraSaida compraSaida = compraService.findById(idCompra);
        if (compraSaida == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity
                .ok()
                .body(compraSaida);

    }

    @GetMapping("/find/all")
    public List<CompraSaida> findAll() {
        return compraService.findAll();
    }
}
