package br.com.fiap.to;

public class OficinaTO {
    private Long oficinaIdOficina;
    private String cnpjOficina;
    private String nomeOficina;

    public OficinaTO() {
    }

    public OficinaTO(Long oficinaIdOficina, String cnpjOficina, String nomeOficina) {
        this.oficinaIdOficina = oficinaIdOficina;
        this.cnpjOficina = cnpjOficina;
        this.nomeOficina = nomeOficina;
    }

    public Long getOficinaIdOficina() {
        return oficinaIdOficina;
    }

    public void setOficinaIdOficina(Long oficinaIdOficina) {
        this.oficinaIdOficina = oficinaIdOficina;
    }

    public String getCnpjOficina() {
        return cnpjOficina;
    }

    public void setCnpjOficina(String cnpjOficina) {
        this.cnpjOficina = cnpjOficina;
    }

    public String getNomeOficina() {
        return nomeOficina;
    }

    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }
}
