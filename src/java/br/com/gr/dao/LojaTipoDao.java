/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.LojaTipo;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class LojaTipoDao extends GenericDAO<LojaTipo> implements Serializable {
    private static final long serialVersionUID = 1L;

    public LojaTipoDao() {
        super(LojaTipo.class);
    }
}