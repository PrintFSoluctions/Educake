package io.github.printf.educake.util.Enums;

import io.github.printf.educake.util.MapUtil;

import java.util.HashMap;
import java.util.Map;

public enum State {
	AC("Acre"),
	AL("Alagoas"),
	AM("Amazonas"),
	AP("Amapá"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	ES("Espirito Santo"),
	GO("Goias"),
	MA("Maranhão"),
	MG("Minas Gerais"),
	MS("Mato Grosso do Sul"),
	MT("Mato Grosso"),
	PA("Pará"),
	PB("Paraiba"),
	PE("Pernanbuco"),
	PI("Piaui"),
	PR("Parana"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RO("Rondônia"),
	RR("Roraima"),
	RS("Rio Grande do Sul"),
	SC("Santa Catarina"),
	SE("Sergipe"),
	SP("São Paulo"),
	TO("Tocantins");

	private String state;

	State(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public static Map<String, String> getAllStates() {
		Map<String, String> allStates = new HashMap<>();

		for (State state : State.values()) {
			allStates.put(state.name(), state.getState());
		}

		allStates = MapUtil.sortByValue(allStates);

		return allStates;
	}

	@Override
	public String toString() {
		return state;
	}
}