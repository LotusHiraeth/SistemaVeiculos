
package br.com.sistemaveiculos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import br.com.sistemaveiculos.model.Veiculo;

@Repository
public class VeiculoRepository {

    private final Map<Long, Veiculo> veiculos = new ConcurrentHashMap<>();

    private final AtomicLong contador = new AtomicLong(1);

    public Veiculo salvar(Veiculo veiculo) {

        if (veiculo.getId() == null) {
            veiculo.setId(contador.getAndIncrement());
        }

        veiculos.put(veiculo.getId(), veiculo);

        return veiculo;
    }

    public List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos.values());
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return Optional.ofNullable(veiculos.get(id));
    }
}
