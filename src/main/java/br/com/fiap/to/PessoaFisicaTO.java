package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class PessoaFisicaTO {
    private Long idPessoaFisica;
    @NotBlank
    private String cpf;
    @NotBlank
    private String genero;
    @NotBlank
    private String nome;
    @PastOrPresent
    private LocalDate dataNascimento;
    @NotNull
    private String telefone;

    public PessoaFisicaTO() {
    }

    public PessoaFisicaTO(Long idPessoaFisica,@NotBlank String cpf,@NotBlank String genero,@NotBlank String nome,@PastOrPresent LocalDate dataNascimento, @NotBlank String telefone) {
        this.idPessoaFisica = idPessoaFisica;
        this.cpf = cpf;
        this.genero = genero;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Long getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(Long idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
