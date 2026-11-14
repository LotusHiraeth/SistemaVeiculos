
package br.com.sistemaveiculos.model;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Veiculo {

    private Long id;

    @NotNull(message = "A marca é obrigatória")
    @Valid
    private Marca marca;

    @NotNull(message = "O modelo é obrigatório")
    @Valid
    private Modelo modelo;

    @Min(value = 1886, message = "Ano de fabricação inválido")
    private int ano;

    private String cor;

    @NotNull(message = "O preço é obrigatório")
    @Min(value = 1, message = "O preço deve ser positivo")
    private BigDecimal preco;

    @Min(value = 0, message = "A quilometragem não pode ser negativa")
    private int quilometragem;

    @NotNull(message = "O status é obrigatório")
    private StatusVeiculo status;

    public Veiculo() {
    }

    public Veiculo(Long id, Marca marca, Modelo modelo,
                   int ano, String cor, BigDecimal preco,
                   int quilometragem, StatusVeiculo status) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.quilometragem = quilometragem;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }
}
