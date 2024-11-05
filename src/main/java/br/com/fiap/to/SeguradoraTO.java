package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class SeguradoraTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;
    private Long idSeguradora;

    public SeguradoraTO() {
    }

    public SeguradoraTO(@NotBlank String nome,@NotBlank String cnpj,@NotBlank String endereco,@NotBlank String telefone, Long idSeguradora) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idSeguradora = idSeguradora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getIdSeguradora() {
        return idSeguradora;
    }

    public void setIdSeguradora(Long idSeguradora) {
        this.idSeguradora = idSeguradora;
    }
}
