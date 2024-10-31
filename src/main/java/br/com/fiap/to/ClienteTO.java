package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClienteTO {
    private Long clienteIdUser;
    private String numeroCNH;
    @NotBlank private String CPFCliente;
    @PastOrPresent private LocalDate dataNascimento;
    @NotNull private char sexo;

    public ClienteTO() {
    }

    public ClienteTO(Long clienteIdUser, String numeroCNH, String CPFCliente, LocalDate dataNascimento, char sexo) {
        this.clienteIdUser = clienteIdUser;
        this.numeroCNH = numeroCNH;
        this.CPFCliente = CPFCliente;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Long getClienteIdUser() {
        return clienteIdUser;
    }

    public void setClienteIdUser(Long clienteIdUser) {
        this.clienteIdUser = clienteIdUser;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH( String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente( String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(@NotNull char sexo) {
        this.sexo = sexo;
    }
}
