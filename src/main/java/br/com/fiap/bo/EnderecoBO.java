package br.com.fiap.bo;

import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.to.EnderecoTO;

import java.util.ArrayList;

public class EnderecoBO {
    private EnderecoDAO enderecoDAO;

    public ArrayList<EnderecoTO> findAll() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        //regra de negocio
        return enderecoDAO.findAll();
    }

    public EnderecoTO findById(Long id) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        //regra de negocio
        return enderecoDAO.findById(id);
    }

    public EnderecoTO save(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        //aqui aplicaria regra de negocio
        return enderecoDAO.save(endereco);
    }

    public  boolean delete(Long codigo) {
        enderecoDAO = new EnderecoDAO();
        //aqui se implementa a regra de negocios especificas
        return enderecoDAO.delete(codigo);
    }

    public EnderecoTO update(EnderecoTO endereco) {
        enderecoDAO = new EnderecoDAO();
        //regra de negocio
        return enderecoDAO.update(endereco);
    }
}
