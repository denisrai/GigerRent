/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Cor;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class CorDao extends GenericDAO<Cor> implements Serializable {
    private static final long serialVersionUID = 1L;

    public CorDao() {
        super(Cor.class);
    }
}
