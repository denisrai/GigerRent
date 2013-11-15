/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 *
 * @author Junior
 */
@Entity
public class SacTipo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idSacTipo;
    
    String nomeSACTipo;
    
    @OneToMany(mappedBy = "sactipo", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    Set<Sac> sacs = new HashSet<Sac>();

    public int getIdSACTipo() {
        return idSacTipo;
    }

    public void setIdSACTipo(int idSACTipo) {
        this.idSacTipo = idSACTipo;
    }

    public String getNomeSACTipo() {
        return nomeSACTipo;
    }

    public void setNomeSACTipo(String nomeSACTipo) {
        this.nomeSACTipo = nomeSACTipo;
    }

    public Set<Sac> getSacs() {
        return sacs;
    }

    public void setSacs(Set<Sac> sacs) {
        this.sacs = sacs;
    }
    
}
