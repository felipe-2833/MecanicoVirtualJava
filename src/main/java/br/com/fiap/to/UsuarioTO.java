package br.com.fiap.to;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class UsuarioTO {
    private Long idUser;
    @NotBlank private String nome;
    @NotBlank private String sobrenome;
    @NotBlank private String email;
    @NotBlank private String senhaHashed;
    @NotBlank private String tipoUsuario;
    @NotBlank private String telefoneCelular;
    @Valid private OficinaTO oficinaTO;
    @Valid private ClienteTO clienteTO;

    public UsuarioTO() {
    }

    public UsuarioTO(Long idUser, String nome, String sobrenome, String email, String senhaHashed, String tipoUsuario, String telefoneCelular) {
        this.idUser = idUser;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senhaHashed = senhaHashed;
        this.tipoUsuario = tipoUsuario;
        this.telefoneCelular = telefoneCelular;
    }

    public Long getIdUser() {
        return idUser;
    }

    public UsuarioTO(Long idUser, String nome, String sobrenome, String email, String senhaHashed, String tipoUsuario, String telefoneCelular, OficinaTO oficinaTO, ClienteTO clienteTO) {
        this.idUser = idUser;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senhaHashed = senhaHashed;
        this.tipoUsuario = tipoUsuario;
        this.telefoneCelular = telefoneCelular;
        this.oficinaTO = oficinaTO;
        this.clienteTO = clienteTO;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHashed() {
        return senhaHashed;
    }

    public void setSenhaHashed(String senhaHashed) {
        this.senhaHashed = senhaHashed;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public OficinaTO getOficinaTO() {
        return oficinaTO;
    }

    public void setOficinaTO(OficinaTO oficinaTO) {
        this.oficinaTO = oficinaTO;
    }

    public ClienteTO getClienteTO() {
        return clienteTO;
    }

    public void setClienteTO(ClienteTO clienteTO) {
        this.clienteTO = clienteTO;
    }
}
