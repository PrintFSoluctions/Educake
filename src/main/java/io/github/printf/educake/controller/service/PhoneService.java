package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.Phone;
import io.github.printf.educake.model.dao.PhoneDAO;
import io.github.printf.educake.util.Enums.PhoneType;

import java.util.ArrayList;

/**
 *
 * @author Albino Freitas
 */
public class PhoneService {

    private final ArrayList<Phone> phones;
    private final PhoneDAO phoneDAO;

    public PhoneService() {
        this.phoneDAO = new PhoneDAO();
        this.phones = new ArrayList();
    }
    
    public boolean validatePhone(ArrayList phoneList, ArrayList type) throws Exception{
        Phone phone;
        
        if(phoneList.size() == type.size()){
            for(int i = 0; i < phoneList.size(); i++){
                phone = new Phone();
                String number = (String) phoneList.get(i);
                number = number.trim();
                
                if(number.length() < 10)
                    throw new Exception("Telefone fora do padrão - (DD)NNNN-NNNN");
                
                phone.setDdd(number.substring(0, 1));
                phone.setPhoneNumber(number.substring(2));
                
                String phoneType = (String) type.get(i);
                
                switch (phoneType){
                    case "Fixo":
                        phone.setDefinition(PhoneType.T);
                        break;
                    case "Celular":
                        phone.setDefinition(PhoneType.C);
                        break;
                }
                
                this.phones.add(phone);
                
            }
        }
        
        return true;
    }
    
    

}
