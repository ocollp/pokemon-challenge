package com.pokemon.domain.shared;

public interface UseCaseWithParameters<I extends UseCaseWithParameters.InputValues, O extends UseCaseWithParameters.OutputValues> {

	O execute(I input) throws Exception;

	interface InputValues {
	}

	interface OutputValues {
	}

	interface UseCaseWithParemetersMapper<E, I extends InputValues, O extends OutputValues> {
		E toEntity(I inputValue);

		O toOutputValues(E entity);
	}
}
