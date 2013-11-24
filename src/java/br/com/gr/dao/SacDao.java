/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Sac;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raison
 */
public class SacDao extends GenericDAO<Sac> implements Serializable {
    private static final long serialVersionUID = 1L;

    public SacDao() {
        super(Sac.class);
    }
    
    //Verificar se nao tem um melhor jeito de fazer a busca 
    public List<Sac> listaQtdSacPorTipo(){
        List<Sac> listaSac = new ArrayList<Sac>();
        iniciarTransacao();
        
        //SELECT count(sac.idSacTipo)c as total, sactipo.nomeSACTipo FROM ginger.sac inner join sactipo on (sac.idSacTipo = sactipo.idSacTipo) group by sac.idSacTipo;
        listaSac = sessao.createQuery("SELECT count(sac.sactipo) as total, sactipo.nomeSACTipo FROM Sac sac INNER JOIN sac.sactipo sactipo group by sac.sactipo").list();

        fecharTransacao();
        
        return listaSac;
    }
}
