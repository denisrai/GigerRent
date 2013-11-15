/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.Funcionario;
import java.io.Serializable;

/**
 *
 * @author Raison
 */
public class FuncionarioDao extends GenericDAO<Funcionario> implements Serializable {
    private static final long serialVersionUID = 1L;

    public FuncionarioDao() {
        super(Funcionario.class);
    }
}
