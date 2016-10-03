package io.github.printf.educake.controller.exceptions;

/**
 * Created by Vitor on 02/10/2016.
 */
public class EmptyException extends Throwable {
	private String field;

	public EmptyException(String field) {
		this.field = field;
	}

	@Override
	public String getMessage() {
		return "O campo " + this.field + " não deve ficar vazio!";
	}
}
