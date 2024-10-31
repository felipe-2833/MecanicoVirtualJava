package br.com.fiap.bo;

import br.com.fiap.dao.OrcamentoPecasDAO;
import br.com.fiap.to.OrcamentoPecasTO;

import java.util.ArrayList;

public class OrcamentoPecasBO {
    private OrcamentoPecasDAO orcamentoPecasDAO;

    public ArrayList<OrcamentoPecasTO> findAll(){
        orcamentoPecasDAO = new OrcamentoPecasDAO();
        return orcamentoPecasDAO.findAll();
    }

    public OrcamentoPecasTO findByCodigo(Long id) {
        orcamentoPecasDAO = new OrcamentoPecasDAO();
        return orcamentoPecasDAO.findByCodigo(id);
    }

    public boolean delete(Long id) {
        orcamentoPecasDAO = new OrcamentoPecasDAO();
        return orcamentoPecasDAO.delete(id);
    }

    public OrcamentoPecasTO update(OrcamentoPecasTO orcamentoPecas) {
        orcamentoPecasDAO = new OrcamentoPecasDAO();
        return orcamentoPecasDAO.update(orcamentoPecas);
    }
}
