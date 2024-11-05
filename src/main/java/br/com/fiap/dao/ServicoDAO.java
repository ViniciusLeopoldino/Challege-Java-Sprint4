package br.com.fiap.dao;


import br.com.fiap.to.ServicoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO extends Repository{
    public ArrayList<ServicoTO> findAll() {
        ArrayList<ServicoTO> servicos = new ArrayList<ServicoTO>();
        String sql = "SELECT * FROM T_CPS_SERVICO order by id_servico";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ServicoTO servico = new ServicoTO();
                    servico.setIdServico(rs.getLong("ID_SERVICO"));
                    servico.setDescricao(rs.getString("DESCRICAO"));
                    servico.setPreco(rs.getFloat("PRECO"));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servicos;
    }

    public ServicoTO findByCodigo(Long codigo) {
        ServicoTO servico = new ServicoTO();
        String sql = "SELECT * FROM T_CPS_SERVICO WHERE id_servico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                servico.setIdServico(rs.getLong("ID_SERVICO"));
                servico.setDescricao(rs.getString("DESCRICAO"));
                servico.setPreco(rs.getFloat("PRECO"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servico;
    }

    public ServicoTO save(ServicoTO servico) {
        String sql = "insert into T_CPS_SERVICO(descricao, preco) values(?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, servico.getDescricao());
            ps.setDouble(2, servico.getPreco());

            if (ps.executeUpdate() > 0) {
                return servico;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_SERVICO where id_servico = ?";
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

    public ServicoTO update(ServicoTO servico) {
        String sql = "update T_CPS_SERVICO set descricao=?, preco=? where id_servico=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, servico.getDescricao());
            ps.setDouble(2, servico.getPreco());
            ps.setLong(3, servico.getIdServico());
            if (ps.executeUpdate() > 0) {
                return servico;
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





