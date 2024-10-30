package br.com.fiap.to;

public class ModeloTO {
    private Long idModelo;
    private Long marcaIdMarca;
    private String nomeModelo;
    private String carroceria;

    public ModeloTO() {
    }

    public ModeloTO(Long idModelo, Long marcaIdMarca, String nomeModelo, String carroceria) {
        this.idModelo = idModelo;
        this.marcaIdMarca = marcaIdMarca;
        this.nomeModelo = nomeModelo;
        this.carroceria = carroceria;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Long getMarcaIdMarca() {
        return marcaIdMarca;
    }

    public void setMarcaIdMarca(Long marcaIdMarca) {
        this.marcaIdMarca = marcaIdMarca;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }
}
