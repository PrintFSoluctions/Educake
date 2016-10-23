package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Albino Freitas
 */
@Entity
@Table
public class CPF implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CPF_SEQUENCE")
    @SequenceGenerator(name = "CPF_SEQUENCE", sequenceName = "CPF_SEQUENCE", allocationSize = 1, initialValue = 1)
    @Column
    private Integer idCpf;
    
    @Column
    private String cpf;
    
    @OneToOne
    private Person person;

    public CPF() {}

    public Integer getIdCpf() {
        return idCpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
