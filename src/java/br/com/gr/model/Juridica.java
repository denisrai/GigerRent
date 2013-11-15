/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Junior
 */
@Entity

public class Juridica extends Cliente
{
    
    String CNPJ;
    String razaoSocial;



    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    
}
