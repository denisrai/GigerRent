/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Loja;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class LojaDao extends GenericDAO<Loja> implements Serializable {
    private static final long serialVersionUID = 1L;

    public LojaDao() {
        super(Loja.class);
    }
}
