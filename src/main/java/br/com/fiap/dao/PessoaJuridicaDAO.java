package br.com.fiap.dao;

import br.com.fiap.to.PessoaJuridicaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaJuridicaDAO extends  Repository{
    public ArrayList<PessoaJuridicaTO> findAll() {
        ArrayList<PessoaJuridicaTO> pessoaJuridicas = new ArrayList<PessoaJuridicaTO>();
        String sql = "SELECT * FROM T_CPS_PESSOA_JURIDICA order by id_pessoa_juridica";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PessoaJuridicaTO pessoaJuridica = new PessoaJuridicaTO();
                    pessoaJuridica.setIdPessoaJuridica(rs.getLong("ID_PESSOA_JURIDICA"));
                    pessoaJuridica.setEmail(rs.getString("EMAIL"));
                    pessoaJuridica.setCnpj(rs.getString("CNPJ"));
                    pessoaJuridica.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                    pessoaJuridica.setSenha(rs.getString("SENHA"));
                    pessoaJuridicas.add(pessoaJuridica);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pessoaJuridicas;
    }

    public PessoaJuridicaTO findByCodigo(Long codigo) {
        PessoaJuridicaTO pessoaJuridica = new PessoaJuridicaTO();
        String sql = "SELECT * FROM T_CPS_PESSOA_JURIDICA WHERE id_pessoa_juridica = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                pessoaJuridica.setIdPessoaJuridica(rs.getLong("ID_PESSOA_JURIDICA"));
                pessoaJuridica.setEmail(rs.getString("EMAIL"));
                pessoaJuridica.setCnpj(rs.getString("CNPJ"));
                pessoaJuridica.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                pessoaJuridica.setSenha(rs.getString("SENHA"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pessoaJuridica;
    }

    public PessoaJuridicaTO save(PessoaJuridicaTO pessoaJuridica) {
        String sql = "insert into T_CPS_PESSOA_JURIDICA(email, cnpj, razao_social,senha) values(?,?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, pessoaJuridica.getEmail());
            ps.setString(2, pessoaJuridica.getCnpj());
            ps.setString(3, pessoaJuridica.getRazaoSocial());
            ps.setString(4, pessoaJuridica.getSenha());
            if (ps.executeUpdate() > 0) {
                return pessoaJuridica;
            }
        } catch (SQLException e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long id_pessoa_juridica) {
        String sql = "delete from T_CPS_PESSOA_JURIDICA where id_pessoa_juridica = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_pessoa_juridica);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return false;
    }

    public PessoaJuridicaTO update(PessoaJuridicaTO pessoaJuridica) {
        String sql = "update T_CPS_PESSOA_JURIDICA set email=?, cnpj=?, razao_social=?, senha=? where id_pessoa_juridica=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
           ps.setString(1, pessoaJuridica.getEmail());
           ps.setString(2, pessoaJuridica.getCnpj());
           ps.setString(3, pessoaJuridica.getRazaoSocial());
           ps.setString(4, pessoaJuridica.getSenha());
           ps.setLong(5, pessoaJuridica.getIdPessoaJuridica());
            if (ps.executeUpdate() > 0) {
                return pessoaJuridica;
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