/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.printf.educake.controller.service;

import io.github.printf.educake.model.CPF;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.dao.CPFDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Albino Freitas
 */
public class CPFService {
    private final CPF cpf;
    private final CPFDAO cpfDAO;

    public CPFService() {
        cpf = new CPF();
        cpfDAO = new CPFDAO();
    }
    
    public void setCPF(Person person, String cpf) throws Exception{
        this.cpf.setPerson(person);
        validateCPF(cpf);
    }
    
    public void setCPF(String cpf) throws Exception{
        validateCPF(cpf);
    }
    
    public CPF getCPF(){
        return this.cpf;
    }
    
    public boolean persist(){
        return cpfDAO.persist(cpf);
    }
    
    //Private Methods
    public void validateCPF(String cpf) throws Exception{
        String regx = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        cpf = cpf.trim();
        Matcher matcherCPF = pattern.matcher(cpf);

        if (!matcherCPF.find()) {
            throw new Exception("Cpf é inválido ou está vazio");
        }
        
        this.cpf.setCpf(cpf);
    }
    
}
