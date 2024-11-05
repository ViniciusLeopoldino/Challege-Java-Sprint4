package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class OficinaTO {
    private Long idOficina;

    @PositiveOrZero
    @NotNull
    private Double preco;
    @NotBlank
    private String endereco;
    @NotBlank
    private String nome;
    @NotBlank
    private String contato;
    @PositiveOrZero
    @NotNull
    private Double maoDeObra;

    public OficinaTO() {
    }

    public OficinaTO(Long idOficina, @PositiveOrZero @NotNull Double preco, @NotBlank String endereco,
                     @NotBlank String nome, @NotBlank String contato, @PositiveOrZero @NotNull Double maoDeObra) {
        this.idOficina = idOficina;
        this.preco = preco;
        this.endereco = endereco;
        this.nome = nome;
        this.contato = contato;
        this.maoDeObra = maoDeObra;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }

    public Double getPreco() {  // Alterado para Double
        return preco;
    }

    public void setPreco(Double preco) {  // Alterado para Double
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(Double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }
}
