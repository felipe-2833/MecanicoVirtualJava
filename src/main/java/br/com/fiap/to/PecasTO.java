package br.com.fiap.to;

public class PecasTO {
    private Long idPecas;
    private String nomePeca;
    private String marca;
    private String modelo;
    private String categoria;
    private Double precoPeca;

    public PecasTO() {
    }

    public PecasTO(Long idPecas, String nomePeca, String marca, String modelo, String categoria, Double precoPeca) {
        this.idPecas = idPecas;
        this.nomePeca = nomePeca;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.precoPeca = precoPeca;
    }

    public Long getIdPecas() {
        return idPecas;
    }

    public void setIdPecas(Long idPecas) {
        this.idPecas = idPecas;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecoPeca() {
        return precoPeca;
    }

    public void setPrecoPeca(Double precoPeca) {
        this.precoPeca = precoPeca;
    }
}
