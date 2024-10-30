package br.com.fiap.to;

public class OficinaServicoTO {
    private Long oficinaIdOficina;
    private Long servicoIdservico;
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
