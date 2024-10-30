package br.com.fiap.to;

public class EnderecoTO {
    private Long idEndereco;
    private Long enderecoIdUser;
    private String cep;
    private String rua;
    private String cidade;
    private String estado;
    private Integer numero;

    public EnderecoTO() {
    }

    public EnderecoTO(Long idEndereco, Long enderecoIdUser, String cep, String rua, String cidade, String estado, Integer numero) {
        this.idEndereco = idEndereco;
        this.enderecoIdUser = enderecoIdUser;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Long getEnderecoIdUser() {
        return enderecoIdUser;
    }

    public void setEnderecoIdUser(Long enderecoIdUser) {
        this.enderecoIdUser = enderecoIdUser;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
