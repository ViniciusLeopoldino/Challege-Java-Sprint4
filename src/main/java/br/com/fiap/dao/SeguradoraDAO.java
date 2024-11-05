package br.com.fiap.dao;

import br.com.fiap.to.SeguradoraTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeguradoraDAO extends Repository {
    public ArrayList<SeguradoraTO> findAll() {
        ArrayList<SeguradoraTO> seguradoras = new ArrayList<SeguradoraTO>();
        String sql = "SELECT * FROM T_CPS_SEGURADORA order by id_seguradora";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    SeguradoraTO seguradora = new SeguradoraTO();
                    seguradora.setIdSeguradora(rs.getLong("ID_SEGURADORA"));
                    seguradora.setNome(rs.getString("NOME"));
                    seguradora.setCnpj(rs.getString("CNPJ"));
                    seguradora.setEndereco(rs.getString("ENDERECO"));
                    seguradora.setTelefone(rs.getString("TELEFONE"));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return seguradoras;
    }

    public SeguradoraTO findByCodigo(Long codigo) {
       SeguradoraTO seguradora = new SeguradoraTO();
        String sql = "SELECT * FROM T_CPS_SEGURADORA WHERE id_seguradora = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                seguradora.setIdSeguradora(rs.getLong("ID_SEGURADORA"));
                seguradora.setNome(rs.getString("NOME"));
                seguradora.setCnpj(rs.getString("CNPJ"));
                seguradora.setEndereco(rs.getString("ENDERECO"));
                seguradora.setTelefone(rs.getString("TELEFONE"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return seguradora;
    }
    public SeguradoraTO save(SeguradoraTO seguradora) {
        String sql = "insert into T_CPS_SEGURADORA(nome, cnpj ,endereco ,telefone) values(?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, seguradora.getNome());
            ps.setString(2, seguradora.getCnpj());
            ps.setString(3, seguradora.getEndereco());
            ps.setString(4, seguradora.getTelefone());
            if (ps.executeUpdate() > 0) {
                return seguradora;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_SEGURADORA where id_seguradora = ?";
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
    public SeguradoraTO update(SeguradoraTO seguradora) {
        String sql = "UPDATE T_CPS_SEGURADORA SET nome = ?, cnpj = ?, endereco = ?, telefone = ? WHERE id_seguradora = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, seguradora.getNome());
            ps.setString(2, seguradora.getCnpj());
            ps.setString(3, seguradora.getEndereco());
            ps.setString(4, seguradora.getTelefone());
            ps.setLong(5, seguradora.getIdSeguradora());

            if (ps.executeUpdate() > 0) {
                return seguradora;
            } else {
                return null; // Caso não encontre o ID para atualização
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

}