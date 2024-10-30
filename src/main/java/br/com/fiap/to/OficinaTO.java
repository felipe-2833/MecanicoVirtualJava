package br.com.fiap.to;

public class OficinaTO {
    private Long oficinaIdUser;
    private String cnpjOficina;
    private String nomeOficina;

    public OficinaTO() {
    }

    public OficinaTO(Long oficinaIdUser, String cnpjOficina, String nomeOficina) {
        this.oficinaIdUser = oficinaIdUser;
        this.cnpjOficina = cnpjOficina;
        this.nomeOficina = nomeOficina;
    }

    public Long getOficinaIdUser() {
        return oficinaIdUser;
    }

    public void setOficinaIdUser(Long oficinaIdUser) {
        this.oficinaIdUser = oficinaIdUser;
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
