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

    public void setCPF(Person person, String cpf) throws Exception {
        this.cpf.setPerson(person);
        newValidateCPF(cpf);
    }

    public void setCPF(String cpf) throws Exception {
        newValidateCPF(cpf);
    }

    public CPF getCPF() {
        return this.cpf;
    }

    public boolean persist() {
        return cpfDAO.persist(cpf);
    }

    //Private Methods
    private void newValidateCPF(String cpf) throws Exception{
        if(!(isValidCPF(cpf) || isValidCNPJ(cpf)))
            throw new Exception("Cpf/Cnpj é inválido ou está vazio");
    }
    
    private void validateCPF(String cpf) throws Exception {
        String regx = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        cpf = cpf.trim();
        Matcher matcherCPF = pattern.matcher(cpf);

        if (!matcherCPF.find()) {
            throw new Exception("Cpf é inválido ou está vazio");
        }

        this.cpf.setCpf(cpf);
    }

    private static final int[] weightCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] weightCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcDigit(String str, int[] weight) {
        int sum = 0;
        for (int index = str.length() - 1, digit; index >= 0; index--) {
            digit = Integer.parseInt(str.substring(index, index + 1));
            sum += digit * weight[weight.length - str.length() + index];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

    private static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer firstDigit = calcDigit(cpf.substring(0, 9), weightCPF);
        Integer secondDigit = calcDigit(cpf.substring(0, 9) + firstDigit, weightCPF);
        return cpf.equals(cpf.substring(0, 9) + firstDigit.toString() + secondDigit.toString());
    }

    private static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcDigit(cnpj.substring(0, 12), weightCNPJ);
        Integer digito2 = calcDigit(cnpj.substring(0, 12) + digito1, weightCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

}
