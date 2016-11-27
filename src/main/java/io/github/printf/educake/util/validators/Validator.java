package io.github.printf.educake.util.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vitor Silvério de Souza On nov, 2016
 */
public class Validator {
    

  /////////////
    // PERSON //
    public Date birthDate(String birthDate) throws ParseException {
        Date date;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);

        try {
            date = dateFormatter.parse(birthDate);
        } catch (ParseException ex) {
            throw new ParseException("Data fora do padrão - DD/MM/AAAA", ex.getErrorOffset());
        }

        return date;
    }

    // FullName
    public String name(String name) throws Exception {
        name = name.trim();
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcherName = pattern.matcher(name);

        if (!matcherName.find()) {
            throw new Exception("Nome é inválido ou está vazio");
        }

        return name;
    }

    // CPF
    public String cpf(String cpf) throws Exception {
        if(!isValidCPF(cpf))
            throw new Exception("Cpf/Cnpj é inválido ou está vazio");
        
        return cpf;
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

    // Telephone
    public String phone(String phone) throws Exception {
        phone.trim();

        if (!phone.matches("\\d{10,11}")) {
            throw new Exception("Telefone informado é invalido! Padrão (DD)NNNN-NNNN");
        }

        return phone;
    }

  //////////////
    // ADDRESS //
    public String city(String city) throws Exception {
        city = city.trim();
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcherCity = pattern.matcher(city);

        if (!matcherCity.find()) {
            throw new Exception("Cidade inválida ou está vazia");
        }

        return city;
    }

    public String district(String district) throws Exception {
        district = district.trim();
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcherCity = pattern.matcher(district);

        if (!matcherCity.find()) {
            throw new Exception("Bairro inválido ou está vazio");
        }

        return district;
    }

    public String cep(String cep) throws Exception {
        System.out.println(cep);
        cep = cep.trim();

        if (!cep.matches("\\d{8}")) {
            throw new Exception("Cep é inválido ou está vazio");
        }

        return cep;
    }

    public int houseNumber(String houseNumber) throws Exception {
        int number;

        try {
            number = Integer.parseInt(houseNumber.trim());
        } catch (NumberFormatException e) {
            throw new Exception("Número da casa não pode conter letras ou caracteres especiais");
        }

        if (number < 0) {
            throw new Exception("Número da casa deve ser positivo");
        }

        return number;
    }
}
