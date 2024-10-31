package br.com.fiap.bo;

import br.com.fiap.dao.OficinaServicoDAO;
import br.com.fiap.to.OficinaServicoTO;

import java.util.ArrayList;

public class OficinaServicoBO {
    private OficinaServicoDAO oficinaServicoDAO;

    public ArrayList<OficinaServicoTO> findAll(){
        oficinaServicoDAO = new OficinaServicoDAO();
        return oficinaServicoDAO.findAll();
    }

    public OficinaServicoTO findByCodigo(Long id) {
        oficinaServicoDAO = new OficinaServicoDAO();
        return oficinaServicoDAO.findByCodigo(id);
    }

    public boolean delete(Long id) {
        oficinaServicoDAO = new OficinaServicoDAO();
        return oficinaServicoDAO.delete(id);
    }

    public OficinaServicoTO update(OficinaServicoTO oficinaServico) {
        oficinaServicoDAO = new OficinaServicoDAO();
        return oficinaServicoDAO.update(oficinaServico);
    }
}
