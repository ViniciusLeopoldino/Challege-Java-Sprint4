package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaAtendimentoTO {
    private Long idReserva;
    @NotBlank
    private String veiculo;
    @NotBlank
    private String oficina;
    @NotBlank
    private String servico;
    @FutureOrPresent
    private LocalDate dataReserva;
    private LocalTime horaReserva;


    public ReservaAtendimentoTO() {
    }

    public ReservaAtendimentoTO(Long idReserva,@NotBlank String veiculo,@NotBlank String oficina,@NotBlank String servico,@FutureOrPresent LocalDate dataReserva, LocalTime horaReserva) {
        this.idReserva = idReserva;
        this.veiculo = veiculo;
        this.oficina = oficina;
        this.servico = servico;
        this.dataReserva = dataReserva;
        this.horaReserva = horaReserva;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalTime horaReserva) {
        this.horaReserva = horaReserva;
    }
}
