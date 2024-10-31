package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class MarcaTO {
    private Long idMarca;
    @NotBlank private String nomeMarca;

    public MarcaTO() {
    }

    public MarcaTO(Long idMarca, String nomeMarca) {
        this.idMarca = idMarca;
        this.nomeMarca = nomeMarca;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}
