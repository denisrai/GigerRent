/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gr.model_webservice;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raison
 */
@XmlRootElement(name = "cors")
@XmlAccessorType(XmlAccessType.FIELD)
public class CoresWebService implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElementWrapper(name = "cors")
    @XmlElement(name = "cor")
    private Collection<CorWebService> cores;

    public Collection<CorWebService> getCores() {
        return cores;
    }

    public void setCores(Collection<CorWebService> cores) {
        this.cores = cores;
    }
}
