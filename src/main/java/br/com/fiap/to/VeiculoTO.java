package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class VeiculoTO {
    @NotBlank
    private String modelo;
    @NotBlank
    private String marca;
    @NotBlank
    private String cor;
    @NotBlank
    private String placa;
    @NotNull
    private Long anoVeiculo;
    @NotNull
    private String chassi;
    private Long idVeiculo;
    private Long idCliente;

    public VeiculoTO() {
    }

    public VeiculoTO(@NotBlank String modelo,@NotBlank String marca,@NotBlank String cor,@NotBlank String placa,@NotNull Long anoVeiculo,@NotBlank String chassi, Long idVeiculo, Long idCliente) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
        this.anoVeiculo = anoVeiculo;
        this.chassi = chassi;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(Long anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
