package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoTO {
    private Long idAgendamento;
    @NotBlank
    private String servico;
    @NotBlank
    private String descricao;
    @NotBlank
    private String status;
    @FutureOrPresent
    private LocalDate dataDeAgendamento;
    private LocalTime horaDeAgendamento;
    private Long idCliente;
    private Long idVeiculo;
    private Long idOficina;

    public AgendamentoTO() {

    }

    public AgendamentoTO(Long idAgendamento, String servico, String descricao, String status, LocalDate dataDeAgendamento, LocalTime horaDeAgendamento, Long idCliente, Long idVeiculo, Long idOficina) {
        this.idAgendamento = idAgendamento;
        this.servico = servico;
        this.descricao = descricao;
        this.status = status;
        this.dataDeAgendamento = dataDeAgendamento;
        this.horaDeAgendamento = horaDeAgendamento;
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.idOficina = idOficina;
    }

    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public @NotBlank String getServico() {
        return servico;
    }

    public void setServico(@NotBlank String servico) {
        this.servico = servico;
    }

    public @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank String descricao) {
        this.descricao = descricao;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }

    public @FutureOrPresent LocalDate getDataDeAgendamento() {
        return dataDeAgendamento;
    }

    public void setDataDeAgendamento(@FutureOrPresent LocalDate dataDeAgendamento) {
        this.dataDeAgendamento = dataDeAgendamento;
    }

    public LocalTime getHoraDeAgendamento() {
        return horaDeAgendamento;
    }

    public void setHoraDeAgendamento(LocalTime horaDeAgendamento) {
        this.horaDeAgendamento = horaDeAgendamento;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Long idOficina) {
        this.idOficina = idOficina;
    }
}

