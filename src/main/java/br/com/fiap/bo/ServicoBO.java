package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.SeguradoraDAO;
import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.SeguradoraTO;
import br.com.fiap.to.ServicoTO;

import java.util.ArrayList;

public class ServicoBO {
    private ServicoDAO servicoDAO;

    public ArrayList<ServicoTO> findAll() {
        servicoDAO = new ServicoDAO();
        //aqui se aplica regra de negocio
        return servicoDAO.findAll();
    }

    public ServicoTO findById(Long id) {
        servicoDAO = new ServicoDAO();
        //aqui se aplica regra de negocio
        return servicoDAO.findByCodigo(id);
    }
    public ServicoTO save(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        //aqui aplicaria regra de negocio
        return servicoDAO.save(servico);
    }
    public  boolean delete(Long codigo) {
        servicoDAO = new ServicoDAO();
        //aqui se implementa a regra de negocios especificas
        return servicoDAO.delete(codigo);
    }

    public ServicoTO update(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        //regra de negocio
        return servicoDAO.update(servico);
    }
}
