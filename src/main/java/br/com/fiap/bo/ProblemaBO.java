package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaDAO;
import br.com.fiap.to.ProblemaTO;

import java.util.ArrayList;

public class ProblemaBO {
    private ProblemaDAO problemaDAO;

    public ArrayList<ProblemaTO> findAll(){
        problemaDAO = new ProblemaDAO();
        return problemaDAO.findAll();
    }

    public ProblemaTO findByCodigo(Long id) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.findByCodigo(id);
    }

    public ProblemaTO save(ProblemaTO problema) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.save(problema);
    }

    public boolean delete(Long id) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.delete(id);
    }

    public ProblemaTO update(ProblemaTO problema) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.update(problema);
    }
}
