
package br.com.sistemaveiculos.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.sistemaveiculos.model.Veiculo;
import br.com.sistemaveiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo cadastrar(Veiculo veiculo) {
        return repository.salvar(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return repository.listarTodos();
    }

    public Veiculo buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Veículo não encontrado"
                ));
    }
}
