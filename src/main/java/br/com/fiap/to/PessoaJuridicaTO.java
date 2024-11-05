package br.com.fiap.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PessoaJuridicaTO {
    private Long idPessoaJuridica;
    @NotBlank @Email
    private String email;
    @PositiveOrZero
    @NotNull
    private String cnpj;
    @NotBlank
    private String razaoSocial;
    @NotBlank
    private String senha;

    public PessoaJuridicaTO() {
    }

    public PessoaJuridicaTO(Long idPessoaJuridica, @NotBlank String email, @PositiveOrZero @NotNull String cnpj, @NotBlank String razaoSocial, @NotBlank String senha) {
        this.idPessoaJuridica = idPessoaJuridica;
        this.email = email;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.senha = senha;
    }

    public Long getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(Long id) {
        this.idPessoaJuridica = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
