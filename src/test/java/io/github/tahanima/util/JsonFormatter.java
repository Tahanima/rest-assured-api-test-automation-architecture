package io.github.tahanima.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tahanima
 */
@Slf4j
public final class JsonFormatter {

    private JsonFormatter() {}

    public static String prettify(Object o) {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("Couldn't format the given object.", e);
        }

        throw new NullPointerException();
    }
}
