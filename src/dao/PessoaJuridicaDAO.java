/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.PessoaJuridica;

/**
 *
 * @author daniel
 */
public class PessoaJuridicaDAO {
    
    
    
    public PessoaJuridica pessoaJuridica(Long id){
        EntityManager manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        PessoaJuridica pj = manager.find(PessoaJuridica.class, id);
//        PessoaJuridica pessoaJuridica = new PessoaJuridica();
//        pessoaJuridica.setId(id);
//        pessoaJuridica.setNome(pj.getNome());
//        pessoaJuridica.setEmail(pj.getEmail());
//        pessoaJuridica.setSite(pj.getSite());
//        pessoaJuridica.setTipo(pj.getTipo());
//        pessoaJuridica.setRazao_social(pj.getRazao_social());
//        pessoaJuridica.setCnpj(pj.getCnpj());
//        pessoaJuridica.setInscrecao_estadual(pj.getInscrecao_estadual());
//        pessoaJuridica.setInscrecao_municipal(pj.getInscrecao_municipal());
        manager.close();
        return pj;
    }
    
    
    
    
    
    
}
