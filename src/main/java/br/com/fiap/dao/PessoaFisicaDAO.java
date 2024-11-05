package br.com.fiap.dao;

import br.com.fiap.to.PessoaFisicaTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaFisicaDAO extends Repository{
    public ArrayList<PessoaFisicaTO> findAll() {
        ArrayList<PessoaFisicaTO> pessoaFisicas = new ArrayList<PessoaFisicaTO>();
        String sql = "SELECT * FROM T_CPS_PESSOA_FISICA order by id_pessoa_fisica";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PessoaFisicaTO pessoaFisica = new PessoaFisicaTO();
                    pessoaFisica.setIdPessoaFisica(rs.getLong("ID_PESSOA_FISICA"));
                    pessoaFisica.setCpf(rs.getString("CPF"));
                    pessoaFisica.setGenero(rs.getString("GENERO"));
                    pessoaFisica.setNome(rs.getString("NOME"));
                    pessoaFisica.setDataNascimento(rs.getDate("DATA_NASCIMENTO").toLocalDate());
                    pessoaFisica.setTelefone(rs.getString("TELEFONE"));
                    pessoaFisicas.add(pessoaFisica);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pessoaFisicas;
    }

    public PessoaFisicaTO findByCodigo(Long codigo) {
        PessoaFisicaTO pessoaFisica = new PessoaFisicaTO();
        String sql = "SELECT * FROM T_CPS_PESSOA_FISICA WHERE id_pessoa_fisica = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                pessoaFisica.setIdPessoaFisica(rs.getLong("ID_PESSOA_FISICA"));
                pessoaFisica.setCpf(rs.getString("CPF"));
                pessoaFisica.setGenero(rs.getString("GENERO"));
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setDataNascimento(rs.getDate("DATA_NASCIMENTO").toLocalDate());
                pessoaFisica.setTelefone(rs.getString("TELEFONE"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pessoaFisica;
    }

    public PessoaFisicaTO save(PessoaFisicaTO pessoaFisica) {
        String sql = "insert into T_CPS_PESSOA_FISICA(cpf, genero, nome, data_nascimento, telefone) values(?,?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, pessoaFisica.getCpf());
            ps.setString(2, pessoaFisica.getGenero());
            ps.setString(3,  pessoaFisica.getNome());
            ps.setDate(4,  Date.valueOf(pessoaFisica.getDataNascimento()));
            ps.setString(5, pessoaFisica.getTelefone());
            if (ps.executeUpdate() > 0) {
                return pessoaFisica;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete from T_CPS_PESSOA_FISICA where id_pessoa_fisica = ?";
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

    public PessoaFisicaTO update(PessoaFisicaTO pessoaFisica) {
        String sql = "update T_CPS_PESSOA_FISICA set cpf=?, genero=?, nome=?, data_nascimento=?, telefone=? where id_pessoa_fisica=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
          ps.setString(1, pessoaFisica.getCpf());
          ps.setString(2, pessoaFisica.getGenero());
          ps.setString(3, pessoaFisica.getNome());
          ps.setDate(4,  Date.valueOf(pessoaFisica.getDataNascimento()));
          ps.setString(5, pessoaFisica.getTelefone());
          ps.setLong(6, pessoaFisica.getIdPessoaFisica());
            if (ps.executeUpdate() > 0) {
                return pessoaFisica;
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