package br.com.fiap.dao;
import br.com.fiap.to.EnderecoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO extends Repository {
    public ArrayList<EnderecoTO> findAll() {
        ArrayList<EnderecoTO> enderecos = new ArrayList<EnderecoTO>();
        String sql = "SELECT * FROM T_CPS_ENDERECO  order by id_endereco";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    EnderecoTO endereco = new EnderecoTO();
                    endereco.setIdEndereco(rs.getLong("ID_ENDERECO"));
                    endereco.setEstado(rs.getString("ESTADO"));
                    endereco.setCidade(rs.getString("CIDADE"));
                    endereco.setBairro(rs.getString("BAIRRO"));
                    endereco.setRua(rs.getString("RUA"));
                    endereco.setNumeroResidencia(rs.getLong("NUMERO_RESIDENCIA"));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return enderecos;
    }

    public EnderecoTO findById(Long id) {
        EnderecoTO endereco = new EnderecoTO();
        String sql = "SELECT * FROM T_CPS_ENDERECO  WHERE id_endereco = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                endereco.setIdEndereco(rs.getLong("ID_ENDERECO"));
                endereco.setEstado(rs.getString("ESTADO"));
                endereco.setCidade(rs.getString("CIDADE"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setRua(rs.getString("RUA"));
                endereco.setNumeroResidencia(rs.getLong("NUMERO_RESIDENCIA"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return endereco;
    }
    public EnderecoTO save(EnderecoTO endereco) {
        String sql = "insert into T_CPS_ENDERECO (estado, cidade, bairro, rua, numero_residencia) values(?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, endereco.getEstado());
            ps.setString(2, endereco.getCidade());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getRua());
            ps.setLong(5, endereco.getNumeroResidencia());
            if (ps.executeUpdate() > 0) {
                return endereco;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_ENDERECO  where id_endereco = ?";
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

    public EnderecoTO update(EnderecoTO endereco) {
        String sql = "update T_CPS_ENDERECO  set estado=?, cidade=?, bairro=?, rua=?,numero_residencia=? where id_endereco=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, endereco.getEstado());
            ps.setString(2, endereco.getCidade());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getRua());
            ps.setLong(5, endereco.getNumeroResidencia());
            ps.setLong(6, endereco.getIdEndereco());
            if (ps.executeUpdate() > 0) {
                return endereco;
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
