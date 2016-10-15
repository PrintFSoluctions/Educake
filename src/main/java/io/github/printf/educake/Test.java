/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake;

import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.controller.service.StudentService;

/**
 *
 * @author albinof
 */
public class Test {
    public static void main(String... args) {
        PersonService person = new PersonService();
        StudentService student = new StudentService();
        
        try{
            person.validateNameAndSurname("Hevelyn", "Mendonça");
            person.validateDate("06/11/2006");
            
            student.setPerson(person.getPeson());
            student.setResponsible(person.getPeson());
            student.generateRm();
            student.persist();
        }catch(Exception e){
            System.out.println(e);
        }
        
        System.exit(0);
        
    }
}
