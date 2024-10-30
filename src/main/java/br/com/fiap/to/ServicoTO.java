package br.com.fiap.to;

public class ServicoTO {
    private Long idServico;
    private String tipoServico;

    public ServicoTO() {
    }

    public ServicoTO(Long idServico, String tipoServico) {
        this.idServico = idServico;
        this.tipoServico = tipoServico;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
}
