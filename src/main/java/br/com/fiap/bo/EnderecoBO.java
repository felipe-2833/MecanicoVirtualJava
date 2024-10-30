package br.com.fiap.bo;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.to.EnderecoTO;

import java.util.ArrayList;

public class EnderecoBO {
    private EnderecoDAO enderecoDAO;

    public ArrayList<EnderecoTO> findAll(){
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findAll();
    }

    public EnderecoTO findByCodigo(Long codigo) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findByCodigo(codigo);
    }

    public EnderecoTO save(EnderecoTO remedio) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.save(remedio);
    }

    public boolean delete(Long codigo) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.delete(codigo);
    }

    public EnderecoTO update(EnderecoTO remedio) {
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.update(remedio);
    }
}
