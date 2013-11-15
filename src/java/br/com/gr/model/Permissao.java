package br.com.gr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permissao implements Serializable {
    @Id

    private String name;

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }
}
