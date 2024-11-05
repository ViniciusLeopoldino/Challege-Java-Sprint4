package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;

import java.util.ArrayList;

public class ClienteBO {
    private ClienteDAO clienteDAO;

    public ArrayList<ClienteTO> findAll() {
        clienteDAO = new ClienteDAO();
        //regra de negocio
        return clienteDAO.findAll();
    }

    public ClienteTO findById(Long id) {
        clienteDAO = new ClienteDAO();
        // regras de negocio
        return clienteDAO.findById(id);
    }

    public ClienteTO save(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        //aqui aplicaria regra de negocio
        return clienteDAO.save(cliente);
    }

    public  boolean delete(Long codigo) {
        clienteDAO = new ClienteDAO();
        //aqui se implementa a regra de negocios especificas
        return clienteDAO.delete(codigo);
    }

    public ClienteTO update(ClienteTO cliente) {
        clienteDAO = new ClienteDAO();
        //regra de negocio
        return clienteDAO.update(cliente);
    }
}
