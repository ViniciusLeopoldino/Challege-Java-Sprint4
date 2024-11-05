package br.com.fiap.bo;


import br.com.fiap.dao.PessoaFisicaDAO;

import br.com.fiap.to.PessoaFisicaTO;

import java.util.ArrayList;

public class PessoaFisicaBO {
    private PessoaFisicaDAO pessoaFisicaDAO;

    public ArrayList<PessoaFisicaTO> findAll() {
        pessoaFisicaDAO = new PessoaFisicaDAO();
        //regra de negocio
        return pessoaFisicaDAO.findAll();
    }
    public PessoaFisicaTO findById(Long id) {
        pessoaFisicaDAO = new PessoaFisicaDAO();
        //regra de negocio
        return pessoaFisicaDAO.findByCodigo(id);
    }
    public PessoaFisicaTO save(PessoaFisicaTO pessoaFisica) {
        pessoaFisicaDAO = new PessoaFisicaDAO();
        //aqui aplicaria regra de negocio
        return pessoaFisicaDAO.save(pessoaFisica);
    }

    public  boolean delete(Long codigo) {
        pessoaFisicaDAO = new PessoaFisicaDAO();
        //aqui se implementa a regra de negocios especificas
        return pessoaFisicaDAO.delete(codigo);
    }

    public PessoaFisicaTO update(PessoaFisicaTO pessoaFisica) {
        pessoaFisicaDAO = new PessoaFisicaDAO();
        //regra de negocio
        return pessoaFisicaDAO.update(pessoaFisica);
    }
}
