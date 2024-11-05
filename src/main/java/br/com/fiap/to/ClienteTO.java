package br.com.fiap.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class ClienteTO {
    @NotBlank
    private String nome;
    @NotNull @Email
    private String email;
    @NotBlank
    private String documento;
    @NotBlank
    private String seguroVeiculo;
    @NotBlank
    private String endereco;
    private Long idCliente;
    @NotNull
    private Long anoNascimento;
    @NotBlank
    private String senha;
    @NotNull
    private Long telefone;

    public ClienteTO() {
    }

    public ClienteTO(@NotBlank String nome,@NotNull @Email String email,@NotBlank String documento,@NotBlank String seguroVeiculo,@NotBlank String endereco, Long idCliente,@NotNull Long anoNascimento,@NotBlank String senha,@NotNull Long telefone) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.seguroVeiculo = seguroVeiculo;
        this.endereco = endereco;
        this.idCliente = idCliente;
        this.anoNascimento = anoNascimento;
        this.senha = senha;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSeguroVeiculo() {
        return seguroVeiculo;
    }

    public void setSeguroVeiculo(String seguroVeiculo) {
        this.seguroVeiculo = seguroVeiculo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Long anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
}
