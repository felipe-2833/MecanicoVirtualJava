package br.com.fiap.bo;

import br.com.fiap.dao.PecasDAO;
import br.com.fiap.to.PecasTO;

import java.util.ArrayList;

public class PecasBO {
    private PecasDAO pecasDAO;

    public ArrayList<PecasTO> findAll(){
        pecasDAO = new PecasDAO();
        return pecasDAO.findAll();
    }

    public PecasTO findByCodigo(Long id) {
        pecasDAO = new PecasDAO();
        return pecasDAO.findByCodigo(id);
    }

    public PecasTO save(PecasTO peca) {
        pecasDAO = new PecasDAO();
        return pecasDAO.save(peca);
    }

    public boolean delete(Long id) {
        pecasDAO = new PecasDAO();
        return pecasDAO.delete(id);
    }

    public PecasTO update(PecasTO peca) {
        pecasDAO = new PecasDAO();
        return pecasDAO.update(peca);
    }
}
