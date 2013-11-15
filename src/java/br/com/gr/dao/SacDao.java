/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Sac;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class SacDao extends GenericDAO<Sac> implements Serializable {
    private static final long serialVersionUID = 1L;

    public SacDao() {
        super(Sac.class);
    }
}
