package com.pokemon.application.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

  private String error;
  private String errorDescription;
  private String errorMessage;
  private List<ErrorReasonDTO> errorReasons;
}
