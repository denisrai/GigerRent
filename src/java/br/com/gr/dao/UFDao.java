/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.dao;

import br.com.gr.model.UF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raison
 */
public class UFDao extends GenericDAO<UF> implements Serializable {
    private static final long serialVersionUID = 1L;

    public UFDao() {
        super(UF.class);
    }
    
    public List<String> getStringList(){
        List<UF> list = this.listar();
        List<String> strings = new ArrayList<String>();
        
        for (UF uf : list) {
            strings.add(uf != null ? uf.getNome(): null);
        }
        
        return strings;
    }
}