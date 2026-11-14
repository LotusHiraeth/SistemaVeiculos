
package br.com.sistemaveiculos.service;

import br.com.sistemaveiculos.model.*;
import br.com.sistemaveiculos.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final MarcaRepository marcaRepository;
    private final ModeloRepository modeloRepository;

    public VeiculoService(
            VeiculoRepository veiculoRepository,
            MarcaRepository marcaRepository,
            ModeloRepository modeloRepository) {
        this.veiculoRepository = veiculoRepository;
        this.marcaRepository = marcaRepository;
        this.modeloRepository = modeloRepository;
    }

    @Transactional
    public Veiculo cadastrar(Veiculo veiculo) {

        Marca marca = marcaRepository
                .findByNomeIgnoreCase(veiculo.getMarca().getNome())
                .orElseGet(() -> marcaRepository.save(
                        new Marca(veiculo.getMarca().getNome())
                ));

        Modelo modelo = modeloRepository.findAll().stream()
                .filter(m -> m.getNome().equalsIgnoreCase(
                        veiculo.getModelo().getNome()))
                .filter(m -> m.getMarca().getId().equals(marca.getId()))
                .findFirst()
                .orElseGet(() -> modeloRepository.save(
                        new Modelo(veiculo.getModelo().getNome(), marca)
                ));

        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);

        if (veiculo.getStatus() == null) {
            veiculo.setStatus(StatusVeiculo.DISPONIVEL);
        }

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Veículo não encontrado"));
    }

    @Transactional
    public Veiculo atualizar(Long id, Veiculo dados) {

        Veiculo veiculo = buscarPorId(id);

        veiculo.setAno(dados.getAno());
        veiculo.setCor(dados.getCor());
        veiculo.setPreco(dados.getPreco());
        veiculo.setQuilometragem(dados.getQuilometragem());
        veiculo.setStatus(dados.getStatus());

        if (dados.getMarca() != null) {
            Marca marca = marcaRepository
                    .findByNomeIgnoreCase(dados.getMarca().getNome())
                    .orElseGet(() -> marcaRepository.save(
                            new Marca(dados.getMarca().getNome())
                    ));

            veiculo.setMarca(marca);
        }

        if (dados.getModelo() != null) {
            Marca marca = veiculo.getMarca();

            Modelo modelo = modeloRepository.findAll().stream()
                    .filter(m -> m.getNome().equalsIgnoreCase(
                            dados.getModelo().getNome()))
                    .filter(m -> m.getMarca().getId().equals(marca.getId()))
                    .findFirst()
                    .orElseGet(() -> modeloRepository.save(
                            new Modelo(dados.getModelo().getNome(), marca)
                    ));

            veiculo.setModelo(modelo);
        }

        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public void excluir(Long id) {
        Veiculo veiculo = buscarPorId(id);
        veiculoRepository.delete(veiculo);
    }

    public List<Veiculo> filtrar(
            String marca,
            String modelo,
            Integer ano,
            BigDecimal precoMin,
            BigDecimal precoMax,
            StatusVeiculo status) {

        return veiculoRepository.filtrar(
                marca, modelo, ano, precoMin, precoMax, status
        );
    }
}
