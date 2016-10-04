package io.github.printf.educake.controller.Exceptions;

/**
 * Created by Vitor on 04/10/2016.
 */
public class RequiredFieldException extends Exception{
	public RequiredFieldException(String field) {
		super("O campo "+ field + " não pode ficar vazio");
	}
}
