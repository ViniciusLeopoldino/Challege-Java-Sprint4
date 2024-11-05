package br.com.fiap.dao;


import br.com.fiap.to.HistoricoManutencaoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistoricoDeManutencaoDAO extends  Repository{
    public ArrayList<HistoricoManutencaoTO> findAll() {
        ArrayList<HistoricoManutencaoTO> historicoManutencoes = new ArrayList<HistoricoManutencaoTO>();
        String sql = "SELECT * FROM T_CPS_HISTORICO_MANUTENCAO order by id_manutencao";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    HistoricoManutencaoTO historico = new HistoricoManutencaoTO();
                    historico.setIdManutencao(rs.getLong("ID_MANUTENCAO"));
                    historico.setNomeUltimaManutencao(rs.getString("NOME_ULTIMA_MANUTENCAO"));
                    historico.setDataManutencao(rs.getDate("DATA_MANUTENCAO").toLocalDate());
                    historico.setDescricao(rs.getString("DESCRICAO"));
                    historico.setObservacao(rs.getString("OBSERVACAO"));
                    historico.setEnderecoUltimaManutencao(rs.getString("ENDERECO_ULTIMA_MANUTENCAO"));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return historicoManutencoes;
    }

    public HistoricoManutencaoTO findByCodigo(Long codigo) {
        HistoricoManutencaoTO historico = new HistoricoManutencaoTO();
        String sql = "SELECT * FROM T_CPS_HISTORICO_MANUTENCAO WHERE id_manutencao = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                historico.setIdManutencao(rs.getLong("ID_MANUTENCAO"));
                historico.setNomeUltimaManutencao(rs.getString("NOME_ULTIMA_MANUTENCAO"));
                historico.setDataManutencao(rs.getDate("DATA_MANUTENCAO").toLocalDate());
                historico.setDescricao(rs.getString("DESCRICAO"));
                historico.setObservacao(rs.getString("OBSERVACAO"));
                historico.setEnderecoUltimaManutencao(rs.getString("ENDERECO_ULTIMA_MANUTENCAO"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return historico;
    }

    public HistoricoManutencaoTO save(HistoricoManutencaoTO historicoManutencao) {
        String sql = "insert into T_CPS_HISTORICO_MANUTENCAO(nome_ultima_manutencao,descricao, observacao, data_manutencao, endereco_ultima_manutencao) values(?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, historicoManutencao.getNomeUltimaManutencao());
            ps.setString(2, historicoManutencao.getDescricao());
            ps.setString(3, historicoManutencao.getObservacao());
            ps.setDate(4, Date.valueOf(historicoManutencao.getDataManutencao()));
            ps.setString(5, historicoManutencao.getEnderecoUltimaManutencao());
            if (ps.executeUpdate() > 0) {
                return historicoManutencao;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_HISTORICO_MANUTENCAO where id_manutencao = ?";
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

    public HistoricoManutencaoTO update(HistoricoManutencaoTO historico) {
        String sql = "UPDATE T_CPS_HISTORICO_MANUTENCAO SET nome_ultima_manutencao=?, descricao=?, observacao=?, endereco_ultima_manutencao=?, data_manutencao=? WHERE id_manutencao=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, historico.getNomeUltimaManutencao());
            ps.setString(2, historico.getDescricao());
            ps.setString(3, historico.getObservacao());
            ps.setString(4, historico.getEnderecoUltimaManutencao());
            ps.setDate(5, Date.valueOf(historico.getDataManutencao())); // Corrigido: dataManutencao no índice 5
            ps.setLong(6, historico.getIdManutencao()); // id_manutencao no índice 6

            if (ps.executeUpdate() > 0) {
                return historico;
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



