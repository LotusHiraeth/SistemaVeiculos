
package br.com.sistemaveiculos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import br.com.sistemaveiculos.model.Veiculo;
import br.com.sistemaveiculos.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrar(
            @Valid @RequestBody Veiculo veiculo) {

        Veiculo novoVeiculo = service.cadastrar(veiculo);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoVeiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {

        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
