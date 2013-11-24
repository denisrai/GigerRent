/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Aluguel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raison
 */

public class AluguelDao extends GenericDAO<Aluguel> implements Serializable {
    private static final long serialVersionUID = 1L;

    public AluguelDao() {
        super(Aluguel.class);
    }
    
    public List<Aluguel> listaQtdAlugueisPorStatus(){
        List<Aluguel> listaAlugueis = new ArrayList<Aluguel>();
        iniciarTransacao();
        
        //SELECT count(*) as total, aluguel.cancelado FROM aluguel group by aluguel.cancelado;
        listaAlugueis = sessao.createQuery("SELECT count(*) as total, alu.cancelado FROM Aluguel alu group by alu.cancelado").list();

        fecharTransacao();
        
        return listaAlugueis;
    }
}