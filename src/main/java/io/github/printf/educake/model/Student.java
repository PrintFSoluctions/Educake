package io.github.printf.educake.model;

import io.github.printf.educake.util.generators.Generator;

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

    public Student(){}

    public void generateRM(){
       this.rm = new Generator().rm();
    }

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

    @Transient
    public String getName() {
        return this.getPerson().getName();
    }
}
