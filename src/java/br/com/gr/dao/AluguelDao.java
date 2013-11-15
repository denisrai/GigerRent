/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Aluguel;
import java.io.Serializable;

/**
 *
 * @author Raison
 */

public class AluguelDao extends GenericDAO<Aluguel> implements Serializable {
    private static final long serialVersionUID = 1L;

    public AluguelDao() {
        super(Aluguel.class);
    }
}