/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Cidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raison
 */
public class CidadeDao extends GenericDAO<Cidade> implements Serializable {
    private static final long serialVersionUID = 1L;

    public CidadeDao() {
        super(Cidade.class);
    }
    
    //Verificar se nao tem um melhor jeito de fazer a busca 
    public Cidade getObjByName(String nome){
        iniciarTransacao();
        Cidade cidade = (Cidade) sessao.createQuery("from Cidade WHERE nome = :nome").setParameter("nome", nome).uniqueResult();
        fecharTransacao();
        return cidade;
    }
    
    //Verificar se nao tem um melhor jeito de fazer a busca 
    public List<String> buscaCidadesEstado(String estado){
        List<String> listaCidades = new ArrayList<String>();
        iniciarTransacao();
        listaCidades = sessao.createQuery("select nomeCidade from Cidade c INNER JOIN estado e WHERE e.nomeEstado = :estado").setParameter("estado", estado).list();
        fecharTransacao();
        
        return listaCidades;
    }
}
