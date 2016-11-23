package io.github.printf.educake.util.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author Vitor Silvério de Souza
*         On nov, 2016
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
    cpf = cpf.trim();
    String regx = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
    Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
    Matcher matcherCPF = pattern.matcher(cpf);

    if (!matcherCPF.find()) {
      throw new Exception("Cpf é inválido ou está vazio");
    }

    return cpf;
  }

  // Telephone
  public String phone(String phone) throws Exception {
    phone.trim();

    if (!phone.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}")) {
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
    cep = cep.trim();
    String regx = "^\\d{5,5}-?\\d{3,3}$";
    Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
    Matcher matcherCep = pattern.matcher(cep);

    if (!matcherCep.find()) {
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

    if(number < 0){
      throw new Exception("Número da casa deve ser positivo");
    }

    return number;
  }
}
