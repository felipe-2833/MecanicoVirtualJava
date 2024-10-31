package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class AgendamentoTO {
    private Long chamadoIdChamado;
    private Long idAgenda;
    @FutureOrPresent private LocalDate dataAgendamentoChamdo;

    public AgendamentoTO() {
    }

    public AgendamentoTO(Long chamadoIdChamado, Long idAgenda, LocalDate dataAgendamentoChamdo) {
        this.chamadoIdChamado = chamadoIdChamado;
        this.idAgenda = idAgenda;
        this.dataAgendamentoChamdo = dataAgendamentoChamdo;
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

    public LocalDate getDataAgendamentoChamdo() {
        return dataAgendamentoChamdo;
    }

    public void setDataAgendamentoChamdo(LocalDate dataAgendamentoChamdo) {
        this.dataAgendamentoChamdo = dataAgendamentoChamdo;
    }
}
