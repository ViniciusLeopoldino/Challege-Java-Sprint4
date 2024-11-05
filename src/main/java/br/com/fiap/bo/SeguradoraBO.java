package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.SeguradoraDAO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.SeguradoraTO;

import java.util.ArrayList;

public class SeguradoraBO {
    private SeguradoraDAO seguradoraDAO;

    public ArrayList<SeguradoraTO> findAll(){
        seguradoraDAO = new SeguradoraDAO();
        //regra de negocio
        return seguradoraDAO.findAll();
    }

    public SeguradoraTO findById(Long id){
        seguradoraDAO = new SeguradoraDAO();
        //regra de negocio
        return seguradoraDAO.findByCodigo(id);
    }

    public SeguradoraTO save(SeguradoraTO seguradora) {
        seguradoraDAO = new SeguradoraDAO();
        //aqui aplicaria regra de negocio
        return seguradoraDAO.save(seguradora);
    }

    public  boolean delete(Long codigo) {
        seguradoraDAO = new SeguradoraDAO();
        //aqui se implementa a regra de negocios especificas
        return seguradoraDAO.delete(codigo);
    }

    public SeguradoraTO update(SeguradoraTO seguradora) {
        seguradoraDAO = new SeguradoraDAO();
        //regra de negocio
        return seguradoraDAO.update(seguradora);
    }
}
