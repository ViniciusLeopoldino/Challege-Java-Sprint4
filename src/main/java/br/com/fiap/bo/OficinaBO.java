package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.OficinaDAO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.OficinaTO;

import java.util.ArrayList;

public class OficinaBO {
    private OficinaDAO oficinaDAO;

    public ArrayList<OficinaTO> findAll() {
        oficinaDAO = new OficinaDAO();
        //regra de negocio
        return oficinaDAO.findAll();
    }

    public OficinaTO findById(Long id) {
        oficinaDAO = new OficinaDAO();
        //regra de negocio
        return oficinaDAO.findByCodigo(id);
    }
    public OficinaTO save(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        //aqui aplicaria regra de negocio
        return oficinaDAO.save(oficina);
    }

    public  boolean delete(Long codigo) {
        oficinaDAO = new OficinaDAO();
        //aqui se implementa a regra de negocios especificas
        return oficinaDAO.delete(codigo);
    }

    public OficinaTO update(OficinaTO oficina) {
        oficinaDAO = new OficinaDAO();
        //regra de negocio
        return oficinaDAO.update(oficina);
    }
}
