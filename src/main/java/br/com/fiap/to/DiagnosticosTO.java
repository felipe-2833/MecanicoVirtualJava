package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class DiagnosticosTO {

    private Long chamadoIdChamado;
    private Long problemaIdProblema;
    private Long idDiagnostico;
    @NotBlank private String problemaIdentificado;
    @NotBlank private String pecasNecessarias;
    @PastOrPresent private LocalDate dataDiagnostico;

    public DiagnosticosTO() {
    }

    public DiagnosticosTO(Long chamadoIdChamado, Long problemaIdProblema, Long idDiagnostico, String problemaIdentificado, String pecasNecessarias, LocalDate dataDiagnostico) {
        this.chamadoIdChamado = chamadoIdChamado;
        this.problemaIdProblema = problemaIdProblema;
        this.idDiagnostico = idDiagnostico;
        this.problemaIdentificado = problemaIdentificado;
        this.pecasNecessarias = pecasNecessarias;
        this.dataDiagnostico = dataDiagnostico;
    }

    public Long getChamadoIdChamado() {
        return chamadoIdChamado;
    }

    public void setChamadoIdChamado(Long chamadoIdChamado) {
        this.chamadoIdChamado = chamadoIdChamado;
    }

    public Long getProblemaIdProblema() {
        return problemaIdProblema;
    }

    public void setProblemaIdProblema(Long problemaIdProblema) {
        this.problemaIdProblema = problemaIdProblema;
    }

    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getProblemaIdentificado() {
        return problemaIdentificado;
    }

    public void setProblemaIdentificado(String problemaIdentificado) {
        this.problemaIdentificado = problemaIdentificado;
    }

    public String getPecasNecessarias() {
        return pecasNecessarias;
    }

    public void setPecasNecessarias(String pecasNecessarias) {
        this.pecasNecessarias = pecasNecessarias;
    }

    public LocalDate getDataDiagnostico() {
        return dataDiagnostico;
    }

    public void setDataDiagnostico(LocalDate dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }
}
