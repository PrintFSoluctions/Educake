package io.github.printf.educake.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Albino Freitas
 */
@Entity
@Table
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQUENCE")
    @SequenceGenerator(name="STUDENT_SEQUENCE", sequenceName = "STUDENT_SEQUENCE", allocationSize = 1,initialValue = 1)
    @Column
    private Integer idStudent;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;
    
    @Column
    private String rm;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idResponsible", nullable = false)
    private Person responsible;

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public Person getResponsible() {
        return responsible;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
    }    
    
}
