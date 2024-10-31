package br.com.fiap.to;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class VeiculoTO {
    private Long idVeiculo;
    private Long idModelo;
    private Long clienteIdUser;
    @NotBlank private String tipoVeiculo;
    @NotBlank private String placaveiculo;
    @Positive @Min(1900) private Integer anoModelo;
    @Positive @Min(1900) private Integer anoFabricacao;
    @Positive private String historicoManutencao;
    @NotBlank private String cor;
    @NotBlank private String combustivel;
    @NotBlank private String motor;
    @NotBlank private Double quilometragem;
    @NotBlank private String tipoOleo;

    public VeiculoTO() {
    }

    public VeiculoTO(Long idVeiculo, Long idModelo, Long clienteIdUser, String tipoVeiculo, String placaveiculo, Integer anoModelo, Integer anoFabricacao, String historicoManutencao, String cor, String combustivel, String motor, Double quilometragem, String tipoOleo) {
        this.idVeiculo = idVeiculo;
        this.idModelo = idModelo;
        this.clienteIdUser = clienteIdUser;
        this.tipoVeiculo = tipoVeiculo;
        this.placaveiculo = placaveiculo;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.historicoManutencao = historicoManutencao;
        this.cor = cor;
        this.combustivel = combustivel;
        this.motor = motor;
        this.quilometragem = quilometragem;
        this.tipoOleo = tipoOleo;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Long getClienteIdUser() {
        return clienteIdUser;
    }

    public void setClienteIdUser(Long clienteIdUser) {
        this.clienteIdUser = clienteIdUser;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(String placaveiculo) {
        this.placaveiculo = placaveiculo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getHistoricoManutencao() {
        return historicoManutencao;
    }

    public void setHistoricoManutencao(String historicoManutencao) {
        this.historicoManutencao = historicoManutencao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getTipoOleo() {
        return tipoOleo;
    }

    public void setTipoOleo(String tipoOleo) {
        this.tipoOleo = tipoOleo;
    }
}
