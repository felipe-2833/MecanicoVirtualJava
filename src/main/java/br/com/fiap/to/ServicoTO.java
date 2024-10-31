package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class ServicoTO {
    private Long idServico;
    @NotBlank private String tipoServico;

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
