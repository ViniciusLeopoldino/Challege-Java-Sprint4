package br.com.fiap.bo;

import br.com.fiap.dao.PecasDAO;
import br.com.fiap.to.PecasTO;

import java.util.ArrayList;

public class PecasBO {
    private PecasDAO pecasDAO;

    public ArrayList<PecasTO> findAll() {
        pecasDAO = new PecasDAO();
        //regra de negocio
        return pecasDAO.findAll();
    }
    public PecasTO findById(Long id) {
        pecasDAO = new PecasDAO();
        //regra de negocio
        return pecasDAO.findById(id);
    }
    public PecasTO save(PecasTO pecas) {
        pecasDAO = new PecasDAO();
        //regra de negocio
        return pecasDAO.save(pecas);
    }
    public boolean delete(Long id) {
        pecasDAO = new PecasDAO();
        //regras de negocio
        return pecasDAO.delete(id);
    }

    public PecasTO update(PecasTO pecas) {
        pecasDAO = new PecasDAO();
        //regra de negocio
        return pecasDAO.update(pecas);
    }
}
