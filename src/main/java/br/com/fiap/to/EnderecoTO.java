package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoTO {
    @NotBlank
    private String estado;
    @NotBlank
    private String cidade;
    @NotBlank
    private String bairro;
    @NotBlank
    private String rua;
    @NotNull
    private Long numeroResidencia;
    private Long idEndereco;

    public EnderecoTO() {
    }

    public EnderecoTO(@NotBlank String estado,@NotBlank String cidade,@NotBlank String bairro,@NotBlank String rua,@NotNull Long numeroResidencia, Long idEndereco) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroResidencia = numeroResidencia;
        this.idEndereco = idEndereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Long numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
}