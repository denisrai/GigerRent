/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Status;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class StatusDao extends GenericDAO<Status> implements Serializable {
    private static final long serialVersionUID = 1L;

    public StatusDao() {
        super(Status.class);
    }
}
