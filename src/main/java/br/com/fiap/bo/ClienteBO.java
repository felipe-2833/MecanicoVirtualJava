package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;

import java.util.ArrayList;

public class ClienteBO {
    private ClienteDAO clienteDAO;

    public ArrayList<ClienteTO> findAll(){
        clienteDAO = new ClienteDAO();
        return clienteDAO.findAll();
    }

    public ClienteTO findByCodigo(Long id) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.findByCodigo(id);
    }

    public boolean delete(Long id) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.delete(id);
    }

    public ClienteTO update(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        return clienteDAO.update(cliente);
    }
}
