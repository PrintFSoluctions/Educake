package io.github.printf.educake;

import io.github.printf.educake.controller.service.AddressService;
import io.github.printf.educake.controller.service.CPFService;
import io.github.printf.educake.controller.service.PersonService;
import io.github.printf.educake.controller.service.PhoneService;
import io.github.printf.educake.controller.service.StudentService;
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
        
        AddressService address = new AddressService();
        PhoneService phones = new PhoneService();
        StudentService student = new StudentService();
        CPFService cpf = new CPFService();
                
        try{
            address.setAddress("Rua", "1", "casa 1", "São Paulo", "13690-010", "SP");
            student.setAddress(address.getAddress());
            
            student.setPerson("Jóse", "Maria", "10/9/1991");
            
            phones.setPhones(listaPhones, listaTypes);
            student.addPhones(phones.getPhones());
            
            cpf.setCPF("000.000.006-00");
            student.setCPF(cpf.getCPF());
            
            student.setStudent(student.getPerson());
            
            student.persist();
        }catch(Exception e){
            System.out.println(e);
        }
        
        System.exit(0);
        
    }
}
