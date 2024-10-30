package br.com.fiap.to;

public class UsuarioTO {
    private Long idUser;
    private String nome;
    private String sobrenome;
    private String email;
    private String senhaHashed;
    private String tipoUsuario;
    private String telefoneCelular;

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
}
