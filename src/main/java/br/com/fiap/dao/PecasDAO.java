package br.com.fiap.dao;

import br.com.fiap.to.PecasTO;

import java.sql.*;
import java.util.ArrayList;

public class PecasDAO extends Repository {

    public ArrayList<PecasTO> findAll() {
        ArrayList<PecasTO> pecas = new ArrayList<>();
        String sql = "SELECT * FROM T_CPS_PECAS ORDER BY id_pecas";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PecasTO pecas1 = new PecasTO();
                pecas1.setId_pecas(rs.getLong("ID_PECAS"));
                pecas1.setNomePecas(rs.getString("NOME_PECAS"));
                pecas1.setChassis(rs.getString("CHASSIS_PECAS"));
                pecas1.setValorPeca(rs.getDouble("VALOR_PECAS"));
                pecas1.setOrigemPecas(rs.getString("ORIGEM_PECAS"));
                pecas1.setQuantidadePecas(rs.getLong("QUANTIDADE_PECAS"));
                pecas.add(pecas1);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pecas;
    }

    public PecasTO findById(Long idPecas) {
        PecasTO peca = new PecasTO();
        String sql = "SELECT * FROM T_CPS_PECAS WHERE id_pecas = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPecas);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                peca.setId_pecas(rs.getLong("ID_PECAS"));
                peca.setNomePecas(rs.getString("NOME_PECAS"));
                peca.setChassis(rs.getString("CHASSIS_PECAS"));
                peca.setValorPeca(rs.getDouble("VALOR_PECAS"));
                peca.setOrigemPecas(rs.getString("ORIGEM_PECAS"));
                peca.setQuantidadePecas(rs.getLong("QUANTIDADE_PECAS"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return peca;
    }

    public PecasTO save(PecasTO pecas) {
        String sql = "INSERT INTO T_CPS_PECAS (nome_pecas, chassis_pecas, valor_pecas, origem_pecas, quantidade_pecas) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, pecas.getNomePecas());
            ps.setString(2, pecas.getChassis());
            ps.setDouble(3, pecas.getValorPeca());
            ps.setString(4, pecas.getOrigemPecas());
            ps.setLong(5, pecas.getQuantidadePecas());
            if (ps.executeUpdate() > 0) {
                return pecas;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long idPecas) {
        String sql = "DELETE FROM T_CPS_PECAS WHERE id_pecas = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPecas);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public PecasTO update(PecasTO pecas) {
        String sql = "UPDATE T_CPS_PECAS SET nome_pecas = ?, chassis_pecas = ?, valor_pecas = ?, origem_pecas = ?, quantidade_pecas = ? WHERE id_pecas = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, pecas.getNomePecas());
            ps.setString(2, pecas.getChassis());
            ps.setDouble(3, pecas.getValorPeca());
            ps.setString(4, pecas.getOrigemPecas());
            ps.setLong(5, pecas.getQuantidadePecas());
            ps.setLong(6, pecas.getId_pecas());
            if (ps.executeUpdate() > 0) {
                return pecas;
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
