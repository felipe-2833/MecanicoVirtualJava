package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ChamadoTO {
    private Long clienteUserId;
    private Long oficinaUserId;
    private Long veiculoUserId;
    private Long idChamdo;
    @NotBlank private String Status;
    @PastOrPresent private LocalDate dataAbertura;

    public ChamadoTO() {
    }

    public ChamadoTO(Long clienteUserId,Long oficinaUserId, Long veiculoUserId, Long idChamdo,String status, LocalDate dataAbertura) {
        this.clienteUserId = clienteUserId;
        this.oficinaUserId = oficinaUserId;
        this.veiculoUserId = veiculoUserId;
        this.idChamdo = idChamdo;
        Status = status;
        this.dataAbertura = dataAbertura;
    }

    public Long getClienteUserId() {
        return clienteUserId;
    }

    public void setClienteUserId(Long clienteUserId) {
        this.clienteUserId = clienteUserId;
    }

    public Long getOficinaUserId() {
        return oficinaUserId;
    }

    public void setOficinaUserId(Long oficinaUserId) {
        this.oficinaUserId = oficinaUserId;
    }

    public Long getVeiculoUserId() {
        return veiculoUserId;
    }

    public void setVeiculoUserId( Long veiculoUserId) {
        this.veiculoUserId = veiculoUserId;
    }

    public Long getIdChamdo() {
        return idChamdo;
    }

    public void setIdChamdo(Long idChamdo) {
        this.idChamdo = idChamdo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus( String status) {
        Status = status;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
