package io.github.tahanima.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * @author tahanima
 */
@Jacksonized
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class User {

    @JsonProperty private int id;

    @JsonProperty private String userName;

    @JsonProperty private String password;
}
