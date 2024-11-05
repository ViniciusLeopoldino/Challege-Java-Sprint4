package br.com.fiap.bo;

import br.com.fiap.dao.ReservaAtendimentoDAO;
import br.com.fiap.to.ReservaAtendimentoTO;

import java.time.LocalTime;
import java.util.ArrayList;

public class ReservaAtendimentoBO {
    private ReservaAtendimentoDAO reservaAtendimentoDAO;

    public ArrayList<ReservaAtendimentoTO> findAll() {
        reservaAtendimentoDAO = new ReservaAtendimentoDAO();
        return reservaAtendimentoDAO.findAll();
    }

    public ReservaAtendimentoTO findById(Long id) {
        reservaAtendimentoDAO = new ReservaAtendimentoDAO();
        return reservaAtendimentoDAO.findByCodigo(id);
    }

    public ReservaAtendimentoTO save(ReservaAtendimentoTO reservaAtendimento) {
        reservaAtendimentoDAO = new ReservaAtendimentoDAO();

        // Verificação do horário de atendimento entre 08:00 e 18:00
        if (reservaAtendimento.getHoraReserva() != null &&
                reservaAtendimento.getHoraReserva().isAfter(LocalTime.of(8, 0)) &&
                reservaAtendimento.getHoraReserva().isBefore(LocalTime.of(18, 0))) {

            return reservaAtendimentoDAO.save(reservaAtendimento);
        } else {
            throw new IllegalArgumentException("Horário fora do horário de atendimento (08:00 - 18:00)");
        }
    }

    public boolean delete(Long codigo) {
        reservaAtendimentoDAO = new ReservaAtendimentoDAO();
        return reservaAtendimentoDAO.delete(codigo);
    }

    public ReservaAtendimentoTO update(ReservaAtendimentoTO reservaAtendimento) {
        reservaAtendimentoDAO = new ReservaAtendimentoDAO();

        // Verificação do horário de atendimento entre 08:00 e 18:00
        if (reservaAtendimento.getHoraReserva() != null &&
                reservaAtendimento.getHoraReserva().isAfter(LocalTime.of(8, 0)) &&
                reservaAtendimento.getHoraReserva().isBefore(LocalTime.of(18, 0))) {

            return reservaAtendimentoDAO.update(reservaAtendimento);
        } else {
            throw new IllegalArgumentException("Horário fora do horário de atendimento (08:00 - 18:00)");
        }
    }
}
