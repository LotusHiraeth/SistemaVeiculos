
package br.com.sistemaveiculos.model;

import jakarta.validation.constraints.NotBlank;

public class Modelo {

    private Long id;

    @NotBlank(message = "O nome do modelo é obrigatório")
    private String nome;

    public Modelo() {
    }

    public Modelo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
