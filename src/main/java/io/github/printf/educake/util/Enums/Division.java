package io.github.printf.educake.util.Enums;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public enum Division {
	HEADER("Cabeçalho"), BODY("Corpo"), FOOTER("Rodapé");

	String division;

	Division(String division) {
		this.division = division;
	}

	public String getDivisionName() {
		return division;
	}
}
