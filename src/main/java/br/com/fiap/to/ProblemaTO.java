package br.com.fiap.to;

public class ProblemaTO {
    private Long veiculoIdVeiculo;
    private Long idProblema;
    private String tipoProblema;
    private String relatoProblema;

    public ProblemaTO() {
    }

    public ProblemaTO(Long veiculoIdVeiculo, Long idProblema, String tipoProblema, String relatoProblema) {
        this.veiculoIdVeiculo = veiculoIdVeiculo;
        this.idProblema = idProblema;
        this.tipoProblema = tipoProblema;
        this.relatoProblema = relatoProblema;
    }

    public Long getVeiculoIdVeiculo() {
        return veiculoIdVeiculo;
    }

    public void setVeiculoIdVeiculo(Long veiculoIdVeiculo) {
        this.veiculoIdVeiculo = veiculoIdVeiculo;
    }

    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public String getRelatoProblema() {
        return relatoProblema;
    }

    public void setRelatoProblema(String relatoProblema) {
        this.relatoProblema = relatoProblema;
    }
}
