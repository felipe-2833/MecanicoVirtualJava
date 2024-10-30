package br.com.fiap.to;

public class OrcamentoTO {
    private Long idOrcamento;
    private Long diagnosticoIdDiagnostico;
    private Long oficinaIdOficina;
    private Long servicoIdServico;

    public OrcamentoTO() {
    }

    public OrcamentoTO(Long idOrcamento, Long oficinaIdOficina, Long diagnosticoIdDiagnostico, Long servicoIdServico) {
        this.idOrcamento = idOrcamento;
        this.oficinaIdOficina = oficinaIdOficina;
        this.diagnosticoIdDiagnostico = diagnosticoIdDiagnostico;
        this.servicoIdServico = servicoIdServico;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Long getDiagnosticoIdDiagnostico() {
        return diagnosticoIdDiagnostico;
    }

    public void setDiagnosticoIdDiagnostico(Long diagnosticoIdDiagnostico) {
        this.diagnosticoIdDiagnostico = diagnosticoIdDiagnostico;
    }

    public Long getOficinaIdOficina() {
        return oficinaIdOficina;
    }

    public void setOficinaIdOficina(Long oficinaIdOficina) {
        this.oficinaIdOficina = oficinaIdOficina;
    }

    public Long getServicoIdServico() {
        return servicoIdServico;
    }

    public void setServicoIdServico(Long servicoIdServico) {
        this.servicoIdServico = servicoIdServico;
    }
}
