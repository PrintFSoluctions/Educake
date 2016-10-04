package io.github.printf.educake.controller.service;

import io.github.printf.educake.controller.Exceptions.RequiredFieldException;
import io.github.printf.educake.model.Person;
import io.github.printf.educake.model.dao.PersonDAO;
import io.github.printf.educake.util.EasyDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vitor on 02/10/2016.
 */
public class PersonService {
	Person person = new Person();
	PersonDAO personDAO = new PersonDAO();
	String name, surname;
	Date birthDate;

	public boolean validateNameAndSurname(String name, String surname) throws Exception {
		String regx = "^[\\p{L} .'-]+$";
		Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
		name = name.trim();
		surname = surname.trim();
		Matcher matcherName = pattern.matcher(name);
		Matcher matcherSurname = pattern.matcher(surname);

                if(!matcherName.find())
			throw new Exception("Nome é inválido ou está vazio");

                if(!matcherSurname.find())
                    throw new Exception("Sobrenome é inválido ou está vazio");

		return true;
	}

	public Date validateDate(String birthDate) throws ParseException {
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		try{
			date = sdf.parse(birthDate);
		}catch (ParseException ex){
			throw new ParseException("Data fora do padrão DD/MM/AAAA", ex.getErrorOffset());
		}

		this.birthDate = EasyDate.rearrangeDate(birthDate);

		return date;
	}

	public boolean persist(String name, String surname, String birthDate) throws Exception {
		boolean result = true;
		validateNameAndSurname(name, surname);
		validateDate(birthDate);
		person = new Person(name, surname, this.birthDate);
		result = personDAO.persist(person);

		return result;
	}
}
