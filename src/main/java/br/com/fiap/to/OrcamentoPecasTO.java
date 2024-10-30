package br.com.fiap.to;

public class OrcamentoPecasTO {

    private Long orcamentoIdOrcamento;
    private Long pecasIdPecas;
    private Double quantidade;

    public OrcamentoPecasTO() {
    }

    public OrcamentoPecasTO(Long orcamentoIdOrcamento, Long pecasIdPecas, Double quantidade) {
        this.orcamentoIdOrcamento = orcamentoIdOrcamento;
        this.pecasIdPecas = pecasIdPecas;
        this.quantidade = quantidade;
    }

    public Long getOrcamentoIdOrcamento() {
        return orcamentoIdOrcamento;
    }

    public void setOrcamentoIdOrcamento(Long orcamentoIdOrcamento) {
        this.orcamentoIdOrcamento = orcamentoIdOrcamento;
    }

    public Long getPecasIdPecas() {
        return pecasIdPecas;
    }

    public void setPecasIdPecas(Long pecasIdPecas) {
        this.pecasIdPecas = pecasIdPecas;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
