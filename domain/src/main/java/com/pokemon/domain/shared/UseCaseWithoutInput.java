package com.pokemon.domain.shared;

public interface UseCaseWithoutInput<O extends UseCaseWithoutInput.OutputValues> {
  O execute() throws Exception;

  interface OutputValues {}
}
