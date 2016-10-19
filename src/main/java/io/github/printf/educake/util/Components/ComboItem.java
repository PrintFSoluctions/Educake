package io.github.printf.educake.util.Components;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public class ComboItem {
	private String value;
	private String text;

	public ComboItem(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		return this.value;
	}

	public String getText() {
		return this.text;
	}

	@Override
	public String toString() {
		return text;
	}
}