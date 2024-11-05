package br.com.fiap.dao;

import br.com.fiap.to.ReservaAtendimentoTO;

import java.sql.*;
import java.util.ArrayList;

public class ReservaAtendimentoDAO extends  Repository{
    public ArrayList<ReservaAtendimentoTO> findAll() {
        ArrayList<ReservaAtendimentoTO> reservaAtendimentos = new ArrayList<>();
        String sql = "SELECT * FROM T_CPS_RESERVA_ATENDIMENTO ORDER BY id_reserva";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ReservaAtendimentoTO reservaAtendimento = new ReservaAtendimentoTO();
                reservaAtendimento.setIdReserva(rs.getLong("ID_RESERVA"));
                reservaAtendimento.setVeiculo(rs.getString("VEICULO"));
                reservaAtendimento.setOficina(rs.getString("OFICINA"));
                reservaAtendimento.setServico(rs.getString("SERVICO"));
                reservaAtendimento.setDataReserva(rs.getDate("DATA_RESERVA").toLocalDate());
                reservaAtendimento.setHoraReserva(rs.getTime("HORA_RESERVA").toLocalTime());
                reservaAtendimentos.add(reservaAtendimento);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return reservaAtendimentos; // Retorna a lista, que pode ser vazia
    }


    public ReservaAtendimentoTO findByCodigo(Long codigo) {
        ReservaAtendimentoTO reservaAtendimento = new ReservaAtendimentoTO();
        String sql = "SELECT * FROM T_CPS_RESERVA_ATENDIMENTO WHERE id_reserva = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                reservaAtendimento.setIdReserva(rs.getLong("idReserva"));
                reservaAtendimento.setVeiculo(rs.getString("veiculo"));
                reservaAtendimento.setOficina(rs.getString("oficina"));
                reservaAtendimento.setServico(rs.getString("servico"));
                reservaAtendimento.setDataReserva(rs.getDate("dataReserva").toLocalDate());
                reservaAtendimento.setHoraReserva(rs.getTime("horaReserva").toLocalTime());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return reservaAtendimento;
    }
    public ReservaAtendimentoTO save(ReservaAtendimentoTO reservaAtendimento) {
        String sql = "INSERT INTO T_CPS_RESERVA_ATENDIMENTO(veiculo, oficina, servico, data_reserva, hora_reserva) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, reservaAtendimento.getVeiculo());
            ps.setString(2, reservaAtendimento.getOficina());
            ps.setString(3, reservaAtendimento.getServico());
            ps.setDate(4, Date.valueOf(reservaAtendimento.getDataReserva()));
            ps.setTime(5, Time.valueOf(reservaAtendimento.getHoraReserva()));
            if (ps.executeUpdate() > 0) {
                return reservaAtendimento;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }


    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_RESERVA_ATENDIMENTO where id_reserva = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return false;
    }

    public ReservaAtendimentoTO update(ReservaAtendimentoTO reservaAtendimento) {
        String sql = "update T_CPS_RESERVA_ATENDIMENTO set veiculo=?, oficina=?, servico=?, data_reserva=?,hora_reserva=? where id_reserva=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
           ps.setString(1, reservaAtendimento.getVeiculo());
           ps.setString(2, reservaAtendimento.getOficina());
           ps.setString(3, reservaAtendimento.getServico());
           ps.setDate(4,  Date.valueOf(reservaAtendimento.getDataReserva()));
           ps.setTime(5,  Time.valueOf(reservaAtendimento.getHoraReserva()));
           ps.setLong(6,reservaAtendimento.getIdReserva());
            if (ps.executeUpdate() > 0) {
                return reservaAtendimento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}





