package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClienteTO {
    private Long clienteIdUser;
    @NotBlank
    private String numeroCNH;
    @NotBlank
    private String CPFCliente;
    @PastOrPresent
    private LocalDate dataNascimento;
    @NotBlank
    private char sexo;

    public ClienteTO() {
    }

    public ClienteTO(Long clienteIdUser, @NotBlank String numeroCNH, @NotBlank String CPFCliente, @PastOrPresent LocalDate dataNascimento, @NotBlank char sexo) {
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

    public @NotBlank String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(@NotBlank String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public @NotBlank String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(@NotBlank String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public @PastOrPresent LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@PastOrPresent LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @NotBlank
    public char getSexo() {
        return sexo;
    }

    public void setSexo(@NotBlank char sexo) {
        this.sexo = sexo;
    }
}
