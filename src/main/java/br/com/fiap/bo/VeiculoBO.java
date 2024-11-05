package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.VeiculoTO;

import java.util.ArrayList;

public class VeiculoBO {
    private VeiculoDAO veiculoDAO;

    public ArrayList<VeiculoTO> findAll() {
        veiculoDAO = new VeiculoDAO();
        //aqui se aplica regra de negocio
        return veiculoDAO.findAll();
    }

    public VeiculoTO findById(Long id) {
        veiculoDAO = new VeiculoDAO();
        //aqui se aplica regra de negocio
        return veiculoDAO.findByCodigo(id);
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        //aqui aplicaria regra de negocio
        return veiculoDAO.save(veiculo);
    }

    public  boolean delete(Long codigo) {
        veiculoDAO = new VeiculoDAO();
        //aqui se implementa a regra de negocios especificas
        return veiculoDAO.delete(codigo);
    }

    public VeiculoTO update(VeiculoTO veiculo) {
        veiculoDAO = new VeiculoDAO();
        //regra de negocio
        return veiculoDAO.update(veiculo);
    }
}
