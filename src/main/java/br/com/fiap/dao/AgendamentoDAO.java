package br.com.fiap.dao;

import br.com.fiap.to.AgendamentoTO;

import java.sql.*;
import java.util.ArrayList;

public class AgendamentoDAO extends Repository {

    public ArrayList<AgendamentoTO> findAll() {
        ArrayList<AgendamentoTO> agendamentos = new ArrayList<AgendamentoTO>();
        String sql = "SELECT * FROM T_CPS_AGENDAMENTO ORDER BY id_agendamento";
        try (PreparedStatement ps =getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    AgendamentoTO agendamento = new AgendamentoTO();
                    agendamento.setIdAgendamento(rs.getLong("id_agendamento"));
                    agendamento.setIdCliente(rs.getLong("id_cliente"));
                    agendamento.setIdOficina(rs.getLong("id_oficina"));
                    agendamento.setIdVeiculo(rs.getLong("id_veiculo"));
                    agendamento.setServico(rs.getString("servico"));
                    agendamento.setDescricao(rs.getString("descricao"));
                    agendamento.setStatus(rs.getString("status"));
                    agendamento.setDataDeAgendamento(rs.getDate("data_de_agendamento").toLocalDate());
                    agendamento.setHoraDeAgendamento(rs.getTime("hora_de_agendamento").toLocalTime());
                    agendamentos.add(agendamento);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamentos;
    }
    public AgendamentoTO findById(Long id) {
        AgendamentoTO agendamento = new AgendamentoTO();
        String sql = "SELECT * FROM T_CPS_AGENDAMENTO WHERE id_agendamento=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()){
                agendamento.setIdAgendamento(rs.getLong("id_agendamento"));
                agendamento.setIdCliente(rs.getLong("id_cliente"));
                agendamento.setIdOficina(rs.getLong("id_oficina"));
                agendamento.setIdVeiculo(rs.getLong("id_veiculo"));
                agendamento.setServico(rs.getString("servico"));
                agendamento.setDescricao(rs.getString("descricao"));
                agendamento.setStatus(rs.getString("status"));
                agendamento.setDataDeAgendamento(rs.getDate("data_de_agendamento").toLocalDate());
                agendamento.setHoraDeAgendamento(rs.getTime("hora_de_agendamento").toLocalTime());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamento;
    }
    public AgendamentoTO save(AgendamentoTO agendamento) {
        String sql = "insert into T_CPS_AGENDAMENTO (id_cliente, id_oficina, id_veiculo, servico, descricao, status, data_de_agendamento, hora_de_agendamento) values (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, agendamento.getIdCliente());
            ps.setLong(2, agendamento.getIdOficina());
            ps.setLong(3, agendamento.getIdVeiculo());
            ps.setString(4, agendamento.getServico());
            ps.setString(5, agendamento.getDescricao());
            ps.setString(6, agendamento.getStatus());
            ps.setDate(7, Date.valueOf(agendamento.getDataDeAgendamento()));
            ps.setTime(8, Time.valueOf(agendamento.getHoraDeAgendamento()));
            if(ps.executeUpdate() > 0){
                return agendamento;
            }
        } catch (SQLException e) {
            System.out.println("erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
    public AgendamentoTO update(AgendamentoTO agendamento) {
        String sql = " update T_CPS_AGENDAMENTO set id_cliente=?, id_oficina=?, id_veiculo=?, servico=?, descricao=?, status=?, data_de_agendamento=?, hora_de_agendamento=? where id_agendamento=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, agendamento.getIdCliente());
            ps.setLong(2, agendamento.getIdOficina());
            ps.setLong(3, agendamento.getIdVeiculo());
            ps.setString(4, agendamento.getServico());
            ps.setString(5, agendamento.getDescricao());
            ps.setString(6, agendamento.getStatus());
            ps.setDate(7, Date.valueOf(agendamento.getDataDeAgendamento()));
            ps.setTime(8, Time.valueOf(agendamento.getHoraDeAgendamento()));
            ps.setLong(9, agendamento.getIdAgendamento());
            if(ps.executeUpdate() > 0){
                return agendamento;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar agendamento" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
    public boolean delete(Long id_agendamento) {
        String sql = "delete from T_CPS_AGENDAMENTO where id_agendamento=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_agendamento);
                return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("erro ao deletar agendamento" + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }
}