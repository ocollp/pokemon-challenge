package com.pokemon.domain.shared;

public interface UseCaseWithoutOutput<I extends UseCaseWithoutOutput.InputValues> {
  void execute(I input) throws Exception;

  interface InputValues {}

  interface UseCaseWithoutOutputMapper<E, I extends InputValues> {
    E toEntity(I input);
  }
}
