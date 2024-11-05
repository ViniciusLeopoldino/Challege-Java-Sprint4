package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ServicoTO {
    private Long idServico;
    @NotBlank
    private String descricao;
    @PositiveOrZero
    @NotNull
    private float preco;

    public ServicoTO() {
    }

    public ServicoTO(Long idServico,@NotBlank String descricao,@FutureOrPresent @NotNull float preco) {
        this.idServico = idServico;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
