package com.pokemon.client.rest;

import com.pokemon.client.dto.request.CreatePokemonRequest;
import com.pokemon.client.dto.request.PokemonRequest;
import com.pokemon.client.dto.response.PokemonResponse;
import com.pokemon.client.utils.RestConstants;
import com.pokemon.client.utils.SwaggerConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(value = RestConstants.RESOURCE_POKEMON, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Pokemon Resource", description = "This is the resource for Pokemon operations")
public interface PokemonApi {

    @GetMapping
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = SwaggerConstants.GENERIC_MESSAGE_200, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PokemonResponse.class)))), @ApiResponse(responseCode = "400", description = SwaggerConstants.GENERIC_MESSAGE_400, content = @Content), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    Page<PokemonResponse> getAllPokemon() throws Exception;

    @GetMapping(value = "/{" + RestConstants.PARAMETER_POKEMON_ID + "}")
    @Operation(summary = SwaggerConstants.RETRIEVE_POKEMON_DESC)
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = SwaggerConstants.GENERIC_MESSAGE_200, content = @Content(schema = @Schema(implementation = PokemonResponse.class))), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    PokemonResponse getPokemonById(@PathVariable(RestConstants.PARAMETER_POKEMON_ID) @Parameter(description = SwaggerConstants.VAR_POKEMON_ID_DESC) UUID pokemonId) throws Exception;

    @PostMapping()
    @Operation(summary = SwaggerConstants.CREATE_POKEMON_DESC)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = SwaggerConstants.GENERIC_MESSAGE_201, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PokemonResponse.class)))), @ApiResponse(responseCode = "400", description = SwaggerConstants.GENERIC_MESSAGE_400, content = @Content), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    PokemonResponse createPokemon(@RequestBody @Validated CreatePokemonRequest createPokemonRequest) throws Exception;

    @PutMapping(value = "/{" + RestConstants.PARAMETER_POKEMON_ID + "}")
    @Operation(summary = SwaggerConstants.EDIT_POKEMON_DESC)
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = SwaggerConstants.GENERIC_MESSAGE_200, content = {@Content(schema = @Schema(implementation = PokemonResponse.class))}), @ApiResponse(responseCode = "400", description = SwaggerConstants.GENERIC_MESSAGE_400, content = @Content), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    PokemonResponse updatePokemon(@RequestBody PokemonRequest pokemonRequest) throws Exception;

    @DeleteMapping
    @Operation(summary = SwaggerConstants.DELETE_POKEMON_DESC)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses({@ApiResponse(responseCode = "204", description = SwaggerConstants.GENERIC_MESSAGE_204), @ApiResponse(responseCode = "400", description = SwaggerConstants.GENERIC_MESSAGE_400, content = @Content), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    void deletePokemon(@PathVariable(RestConstants.PARAMETER_POKEMON_ID) @Parameter(description = SwaggerConstants.VAR_POKEMON_ID_DESC) UUID pokemonId) throws Exception;

    @GetMapping
    @Operation(summary = SwaggerConstants.RETRIEVE_POKEMON_BY_NAME_PREFIX_DESC)
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = SwaggerConstants.GENERIC_MESSAGE_200, content = @Content(schema = @Schema(implementation = PokemonResponse.class))), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    List<PokemonResponse> pokemonWithNamePrefix(@PathVariable(RestConstants.PARAMETER_POKEMON_NAME_STARTS_WITH) @Parameter(description = SwaggerConstants.VAR_POKEMON_NAME_STARTS_WITH_DESC) UUID pokemonId) throws Exception;

    @GetMapping(value = "/" + RestConstants.RESOURCE_TOP_HEAVIEST)
    @Operation(summary = SwaggerConstants.RETRIEVE_HEAVIEST_POKEMON_DESC)
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = SwaggerConstants.GENERIC_MESSAGE_200, content = @Content(schema = @Schema(implementation = PokemonResponse.class))), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    List<PokemonResponse> topHeaviest(@PathVariable(RestConstants.PARAMETER_LIMIT) @Parameter(description = SwaggerConstants.VAR_LIMIT_DESC) int limit) throws Exception;

    @GetMapping(value = "/" + RestConstants.RESOURCE_TOP_EXPERIENCE)
    @Operation(summary = SwaggerConstants.RETRIEVE_TOP_EXPERIENCE_POKEMON_DESC)
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = SwaggerConstants.GENERIC_MESSAGE_200, content = @Content(schema = @Schema(implementation = PokemonResponse.class))), @ApiResponse(responseCode = "404", description = SwaggerConstants.GENERIC_MESSAGE_404, content = @Content)})
    List<PokemonResponse> topExperience(@PathVariable(RestConstants.PARAMETER_LIMIT) @Parameter(description = SwaggerConstants.VAR_LIMIT_DESC) int limit) throws Exception;
}