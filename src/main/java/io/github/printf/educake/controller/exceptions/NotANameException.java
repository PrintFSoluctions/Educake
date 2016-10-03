package io.github.printf.educake.controller.exceptions;

/**
 * Created by Vitor on 02/10/2016.
 */
public class NotANameException extends Throwable {
	@Override
	public String getMessage() {
		return "O nome contém carácteres inválidos!";
	}
}
