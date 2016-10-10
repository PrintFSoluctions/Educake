package io.github.printf.educake.util.Enums;

import java.awt.*;

/**
 * @author Vitor Silvério de Souza
 *         On out, 2016
 */
public enum Flex{
	HORIZONTAL(GridBagConstraints.HORIZONTAL),
	VERTICAL(GridBagConstraints.VERTICAL),
	BOTH(GridBagConstraints.BOTH),
	NONE(GridBagConstraints.NONE);

	private final int flex;

	Flex(int flex) {
		this.flex = flex;
	}

	public int getFlex(){
		return flex;
	}
}