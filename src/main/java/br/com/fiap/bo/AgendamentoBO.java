package br.com.fiap.bo;

import br.com.fiap.dao.AgendamentoDAO;
import br.com.fiap.to.AgendamentoTO;

import java.time.LocalTime;
import java.util.ArrayList;

public class AgendamentoBO {
    private AgendamentoDAO agendamentoDAO;

    public ArrayList<AgendamentoTO> findAll() {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.findAll();
    }

    public AgendamentoTO findById(Long id) {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.findById(id);
    }

    public AgendamentoTO save(AgendamentoTO agendamento) {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.save(agendamento);
    }


    public boolean delete(Long codigo) {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.delete(codigo);
    }

    public AgendamentoTO update(AgendamentoTO agendamento) {
       agendamentoDAO = new AgendamentoDAO();
       return agendamentoDAO.update(agendamento);
    }
}
