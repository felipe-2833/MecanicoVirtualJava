package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class AgendamentoTO {
    @NotNull @Positive
    private Long chamadoIdChamado;
    private Long idAgenda;
    @FutureOrPresent
    private LocalDate dataAgendamentoChamdo;

    public AgendamentoTO() {
    }

    public AgendamentoTO(@NotNull @Positive Long chamadoIdChamado, Long idAgenda, @FutureOrPresent LocalDate dataAgendamentoChamdo) {
        this.chamadoIdChamado = chamadoIdChamado;
        this.idAgenda = idAgenda;
        this.dataAgendamentoChamdo = dataAgendamentoChamdo;
    }

    public @NotNull @Positive Long getChamadoIdChamado() {
        return chamadoIdChamado;
    }

    public void setChamadoIdChamado(@NotNull @Positive Long chamadoIdChamado) {
        this.chamadoIdChamado = chamadoIdChamado;
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public @FutureOrPresent LocalDate getDataAgendamentoChamdo() {
        return dataAgendamentoChamdo;
    }

    public void setDataAgendamentoChamdo(@FutureOrPresent LocalDate dataAgendamentoChamdo) {
        this.dataAgendamentoChamdo = dataAgendamentoChamdo;
    }
}
