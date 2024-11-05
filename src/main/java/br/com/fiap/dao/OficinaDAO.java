package br.com.fiap.dao;

import br.com.fiap.to.OficinaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO extends Repository {
    public ArrayList<OficinaTO> findAll() {
        ArrayList<OficinaTO> Oficinas = new ArrayList<OficinaTO>();
        String sql = "SELECT * FROM T_CPS_OFICINA order by id_oficina";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    OficinaTO oficina = new OficinaTO();
                    oficina.setIdOficina(rs.getLong("ID_OFICINA"));
                    oficina.setPreco(rs.getDouble("PRECO"));
                    oficina.setEndereco(rs.getString("ENDERECO"));
                    oficina.setNome(rs.getString("NOME"));
                    oficina.setContato(rs.getString("CONTATO"));
                    oficina.setMaoDeObra(rs.getDouble("MAO_DE_OBRA"));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return Oficinas;
    }

    public OficinaTO findByCodigo(Long codigo) {
        OficinaTO oficina = new OficinaTO();
        String sql = "SELECT * FROM T_CPS_OFICINA WHERE id_oficina = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                oficina.setIdOficina(rs.getLong("ID_OFICINA"));
                oficina.setPreco(rs.getDouble("PRECO"));
                oficina.setEndereco(rs.getString("ENDERECO"));
                oficina.setNome(rs.getString("NOME"));
                oficina.setContato(rs.getString("CONTATO"));
                oficina.setMaoDeObra(rs.getDouble("MAO_DE_OBRA"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return oficina;
    }

    public OficinaTO save(OficinaTO oficina) {
        String sql = "insert into T_CPS_OFICINA(preco, endereco, nome, contato, mao_de_obra) values(?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDouble(1, oficina.getPreco());
            ps.setString(2, oficina.getEndereco());
            ps.setString(3, oficina.getNome());
            ps.setString(4, oficina.getContato());
            ps.setDouble(5, oficina.getMaoDeObra());
            if (ps.executeUpdate() > 0) {
                return oficina;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_OFICINA where id_oficina = ?";
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

    public OficinaTO update(OficinaTO oficina) {
        String sql = "update T_CPS_OFICINA set preco=?, endereco=?, nome=?, contato=?, mao_de_obra=? where id_oficina=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDouble(1, oficina.getPreco()); // Certifique-se de que getPreco() retorna Double
            ps.setString(2, oficina.getEndereco());
            ps.setString(3, oficina.getNome());
            ps.setString(4, oficina.getContato());
            ps.setDouble(5, oficina.getMaoDeObra()); // Alterado para setDouble
            ps.setLong(6, oficina.getIdOficina());
            if (ps.executeUpdate() > 0) {
                return oficina;
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
