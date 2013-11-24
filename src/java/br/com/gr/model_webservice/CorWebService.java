/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model_webservice;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raison
 */
@Entity
@Table(name = "cor")
@XmlRootElement(name = "cor")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "CorWebService.findAll", query = "SELECT c FROM CorWebService c"),
    @NamedQuery(name = "CorWebService.findByIdCor", query = "SELECT c FROM CorWebService c WHERE c.idCor = :idCor"),
    @NamedQuery(name = "CorWebService.findByNomeCor", query = "SELECT c FROM CorWebService c WHERE c.nomeCor = :nomeCor")})
public class CorWebService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCor")
    @XmlElement(name = "idCor")
    private Integer idCor;
    
    @Size(max = 200)
    @Column(name = "nomeCor")
    @XmlElement(name = "nomeCor")
    private String nomeCor;

    public CorWebService() {
    }

    public CorWebService(Integer idCor) {
        this.idCor = idCor;
    }

    public Integer getIdCor() {
        return idCor;
    }

    public void setIdCor(Integer idCor) {
        this.idCor = idCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }

    public void setNomeCor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCor != null ? idCor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorWebService)) {
            return false;
        }
        CorWebService other = (CorWebService) object;
        if ((this.idCor == null && other.idCor != null) || (this.idCor != null && !this.idCor.equals(other.idCor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gr.model_webservice.CorWebService[ idCor=" + idCor + " ]";
    }
    
}
