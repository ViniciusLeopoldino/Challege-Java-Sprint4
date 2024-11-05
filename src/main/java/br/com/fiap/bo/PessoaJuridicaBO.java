package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PessoaJuridicaDAO;
import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.PessoaJuridicaTO;

import java.util.ArrayList;

public class PessoaJuridicaBO {
    private PessoaJuridicaDAO pessoaJuridicaDAO;

    public ArrayList<PessoaJuridicaTO> findAll() {
        pessoaJuridicaDAO = new PessoaJuridicaDAO();
        //regra de negocio
        return pessoaJuridicaDAO.findAll();
    }

    public PessoaJuridicaTO findById(Long id) {
        pessoaJuridicaDAO = new PessoaJuridicaDAO();
        // regra de negocio
        return pessoaJuridicaDAO.findByCodigo(id);
    }

    public PessoaJuridicaTO save(PessoaJuridicaTO pessoaJuridica) {
        pessoaJuridicaDAO = new PessoaJuridicaDAO();
        //aqui aplicaria regra de negocio
        return pessoaJuridicaDAO.save(pessoaJuridica);
    }

    public  boolean delete(Long codigo) {
        pessoaJuridicaDAO = new PessoaJuridicaDAO();
        //aqui se implementa a regra de negocios especificas
        return pessoaJuridicaDAO.delete(codigo);
    }

    public PessoaJuridicaTO update(PessoaJuridicaTO pessoaJuridica) {
        pessoaJuridicaDAO = new PessoaJuridicaDAO();
        //regra de negocio
        return pessoaJuridicaDAO.update(pessoaJuridica);
    }
}
