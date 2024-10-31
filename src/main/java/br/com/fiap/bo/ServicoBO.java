package br.com.fiap.bo;

import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.to.ServicoTO;

import java.util.ArrayList;

public class ServicoBO {
    private ServicoDAO servicoDAO;

    public ArrayList<ServicoTO> findAll(){
        servicoDAO = new ServicoDAO();
        return servicoDAO.findAll();
    }

    public ServicoTO findByCodigo(Long id) {
        servicoDAO = new ServicoDAO();
        return servicoDAO.findByCodigo(id);
    }

    public ServicoTO save(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        return servicoDAO.save(servico);
    }

    public boolean delete(Long id) {
        servicoDAO = new ServicoDAO();
        return servicoDAO.delete(id);
    }

    public ServicoTO update(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        return servicoDAO.update(servico);
    }
}
