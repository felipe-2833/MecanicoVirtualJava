package br.com.fiap.to;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class ServicoTO {
    private Long idServico;
    @NotBlank private String tipoServico;
    @Valid OficinaServicoTO oficinaServicoTO;

    public ServicoTO() {
    }

    public ServicoTO(Long idServico, String tipoServico, OficinaServicoTO oficinaServicoTO) {
        this.idServico = idServico;
        this.tipoServico = tipoServico;
        this.oficinaServicoTO = oficinaServicoTO;
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

    public OficinaServicoTO getOficinaServicoTO() {
        return oficinaServicoTO;
    }

    public void setOficinaServicoTO(OficinaServicoTO oficinaServicoTO) {
        this.oficinaServicoTO = oficinaServicoTO;
    }
}
