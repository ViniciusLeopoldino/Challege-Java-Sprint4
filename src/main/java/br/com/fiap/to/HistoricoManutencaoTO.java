package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;


public class HistoricoManutencaoTO {
    private Long idManutencao;
    @NotBlank
    private String nomeUltimaManutencao;
    @NotBlank
    private String descricao;
    @NotBlank
    private String observacao;
    @PastOrPresent
    private LocalDate dataManutencao;
    private String enderecoUltimaManutencao;

    public HistoricoManutencaoTO() {
    }


    public HistoricoManutencaoTO(Long idManutencao,@NotBlank String nomeUltimaManutencao,@NotBlank String descricao,@NotBlank String observacao,@PastOrPresent LocalDate dataManutencao, String enderecoUltimaManutencao) {
        this.idManutencao = idManutencao;
        this.nomeUltimaManutencao = nomeUltimaManutencao;
        this.descricao = descricao;
        this.observacao = observacao;
        this.dataManutencao = dataManutencao;
        this.enderecoUltimaManutencao = enderecoUltimaManutencao;
    }

    public Long getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Long idManutencao) {
        this.idManutencao = idManutencao;
    }

    public String getNomeUltimaManutencao() {
        return nomeUltimaManutencao;
    }

    public void setNomeUltimaManutencao(String nomeUltimaManutencao) {
        this.nomeUltimaManutencao = nomeUltimaManutencao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observcao) {
        this.observacao = observcao;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getEnderecoUltimaManutencao() {
        return enderecoUltimaManutencao;
    }

    public void setEnderecoUltimaManutencao(String enderecoUltimaManutencao) {
        this.enderecoUltimaManutencao = enderecoUltimaManutencao;
    }
}
