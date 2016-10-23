package io.github.printf.educake.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Thaila
 */

@Entity
@Table
public class Teacher implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEACHER_SEQUENCE")
    @SequenceGenerator(name="TEACHER_SEQUENCE", sequenceName = "TEACHER_SEQUENCE", allocationSize = 1,initialValue = 1)
    @Column
    private Long idTeacher;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;
    
    public Long getIdTeacher() {
        return idTeacher;
    }
    
    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }
    
    public Person getPerson(){
        return person;
    }
    
    public void setPerson(Person person){
        this.person = person;
    }
}
