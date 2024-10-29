package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ChamadoTO {
    @NotNull @Positive
    private Long clienteUserId;
    @NotNull @Positive
    private Long oficinaUserId;
    @NotNull @Positive
    private Long veiculoUserId;
    private Long idChamdo;
    @NotBlank
    private String Status;
    @PastOrPresent
    private LocalDate dataAbertura;

    public ChamadoTO() {
    }

    public ChamadoTO(@NotNull @Positive Long clienteUserId,@NotNull @Positive Long oficinaUserId, @NotNull @Positive Long veiculoUserId, Long idChamdo,@NotBlank String status, @PastOrPresent LocalDate dataAbertura) {
        this.clienteUserId = clienteUserId;
        this.oficinaUserId = oficinaUserId;
        this.veiculoUserId = veiculoUserId;
        this.idChamdo = idChamdo;
        Status = status;
        this.dataAbertura = dataAbertura;
    }

    public @NotNull @Positive Long getClienteUserId() {
        return clienteUserId;
    }

    public void setClienteUserId(@NotNull @Positive Long clienteUserId) {
        this.clienteUserId = clienteUserId;
    }

    public @NotNull @Positive Long getOficinaUserId() {
        return oficinaUserId;
    }

    public void setOficinaUserId(@NotNull @Positive Long oficinaUserId) {
        this.oficinaUserId = oficinaUserId;
    }

    public @NotNull @Positive Long getVeiculoUserId() {
        return veiculoUserId;
    }

    public void setVeiculoUserId(@NotNull @Positive Long veiculoUserId) {
        this.veiculoUserId = veiculoUserId;
    }

    public Long getIdChamdo() {
        return idChamdo;
    }

    public void setIdChamdo(Long idChamdo) {
        this.idChamdo = idChamdo;
    }

    public @NotBlank String getStatus() {
        return Status;
    }

    public void setStatus(@NotBlank String status) {
        Status = status;
    }

    public @PastOrPresent LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(@PastOrPresent LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
