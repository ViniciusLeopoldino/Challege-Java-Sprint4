package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.HistoricoDeManutencaoDAO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.HistoricoManutencaoTO;

import java.util.ArrayList;

public class HistoricoManutencaoBO {
    private HistoricoDeManutencaoDAO historicoDeManutencaoDAO;

    public ArrayList<HistoricoManutencaoTO> findAll() {
        historicoDeManutencaoDAO = new HistoricoDeManutencaoDAO();
        //regra de negocio
        return historicoDeManutencaoDAO.findAll();
    }

    public HistoricoManutencaoTO findById(Long id) {
        historicoDeManutencaoDAO = new HistoricoDeManutencaoDAO();
        //regra de negocio
        return historicoDeManutencaoDAO.findByCodigo(id);
    }

    public HistoricoManutencaoTO save(HistoricoManutencaoTO historicoManutencao) {
        historicoDeManutencaoDAO = new HistoricoDeManutencaoDAO();
        //aqui aplicaria regra de negocio
        return historicoDeManutencaoDAO.save(historicoManutencao);
    }

    public  boolean delete(Long codigo) {
        historicoDeManutencaoDAO = new HistoricoDeManutencaoDAO();
        //aqui se implementa a regra de negocios especificas
        return historicoDeManutencaoDAO.delete(codigo);
    }

    public HistoricoManutencaoTO update(HistoricoManutencaoTO historicoManutencao) {
        historicoDeManutencaoDAO = new HistoricoDeManutencaoDAO();
        //regra de negocociio
        return historicoDeManutencaoDAO.update(historicoManutencao);
    }
}
