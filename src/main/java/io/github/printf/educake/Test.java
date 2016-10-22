/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake;

import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.controller.service.PhoneService;
import java.util.ArrayList;


/**
 *
 * @author albinof
 */
public class Test {
    public static void main(String... args) {
        ArrayList<String> listaPhones = new ArrayList();
        ArrayList<String> listaTypes = new ArrayList();
        
        listaPhones.add("22222222222");
        listaTypes.add("Celular");
        
        listaPhones.add("1111111111");
        listaTypes.add("Fixo");
        
        PersonService person = new PersonService();
        PhoneService phones = new PhoneService();
                
        try{
            person.setPerson("Albino", "Freitas", "10/09/1991");
            phones.setPhones(listaPhones, listaTypes);
            person.addPhones(phones.getPhones());                    
            person.persist();
        }catch(Exception e){
            System.out.println(e);
        }
        
        System.exit(0);
        
    }
}
