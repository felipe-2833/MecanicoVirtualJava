package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

public class AgendamentoTO {
    private Long chamadoIdChamado;
    private Long idAgenda;
    @FutureOrPresent
    private LocalDate dataAgendamentoChamado;

    public AgendamentoTO() {
    }

    public AgendamentoTO(Long chamadoIdChamado, Long idAgenda, LocalDate dataAgendamentoChamado) {
        this.chamadoIdChamado = chamadoIdChamado;
        this.idAgenda = idAgenda;
        this.dataAgendamentoChamado = dataAgendamentoChamado;
    }

    public Long getChamadoIdChamado() {
        return chamadoIdChamado;
    }

    public void setChamadoIdChamado(Long chamadoIdChamado) {
        this.chamadoIdChamado = chamadoIdChamado;
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public LocalDate getDataAgendamentoChamado() {
        return dataAgendamentoChamado;
    }

    public void setDataAgendamentoChamado(LocalDate dataAgendamentoChamado) {
        this.dataAgendamentoChamado = dataAgendamentoChamado;
    }
}
