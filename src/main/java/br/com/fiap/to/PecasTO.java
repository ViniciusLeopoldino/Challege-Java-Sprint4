package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PecasTO {
    private Long id_pecas;

    @NotBlank
    private String nomePecas;

    @NotBlank
    private String chassis;

    @NotNull
    private Double valorPeca; // Alterado para Double para maior precisão em valores monetários

    @NotBlank
    private String origemPecas;

    @NotNull
    @PositiveOrZero
    private Long quantidadePecas;

    public PecasTO() {
    }

    public PecasTO(Long id_pecas, @NotBlank String nomePecas, @NotBlank String chassis,
                   @NotNull Double valorPeca, @NotBlank String origemPecas,
                   @NotNull @PositiveOrZero Long quantidadePecas) {
        this.id_pecas = id_pecas;
        this.nomePecas = nomePecas;
        this.chassis = chassis;
        this.valorPeca = valorPeca;
        this.origemPecas = origemPecas;
        this.quantidadePecas = quantidadePecas;
    }

    public Long getId_pecas() {
        return id_pecas;
    }

    public void setId_pecas(Long id_pecas) {
        this.id_pecas = id_pecas;
    }

    public String getNomePecas() {
        return nomePecas;
    }

    public void setNomePecas(String nomePecas) {
        this.nomePecas = nomePecas;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public Double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(Double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public String getOrigemPecas() {
        return origemPecas;
    }

    public void setOrigemPecas(String origemPecas) {
        this.origemPecas = origemPecas;
    }

    public Long getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(Long quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }
}
