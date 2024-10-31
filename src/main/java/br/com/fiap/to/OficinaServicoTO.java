package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class OficinaServicoTO {
    private Long oficinaIdOficina;
    private Long servicoIdservico;
    @NotNull @PositiveOrZero
    private Double precoServico;

    public OficinaServicoTO() {
    }

    public OficinaServicoTO(Long oficinaIdOficina, Long servicoIdservico, Double precoServico) {
        this.oficinaIdOficina = oficinaIdOficina;
        this.servicoIdservico = servicoIdservico;
        this.precoServico = precoServico;
    }

    public Long getOficinaIdOficina() {
        return oficinaIdOficina;
    }

    public void setOficinaIdOficina(Long oficinaIdOficina) {
        this.oficinaIdOficina = oficinaIdOficina;
    }

    public Long getServicoIdservico() {
        return servicoIdservico;
    }

    public void setServicoIdservico(Long servicoIdservico) {
        this.servicoIdservico = servicoIdservico;
    }

    public Double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(Double precoServico) {
        this.precoServico = precoServico;
    }
}
