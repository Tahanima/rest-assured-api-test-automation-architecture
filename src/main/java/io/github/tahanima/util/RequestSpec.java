package io.github.tahanima.util;

import static io.github.tahanima.config.ConfigurationManager.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * @author tahanima
 */
public final class RequestSpec {

    private RequestSpec() {}

    public static RequestSpecification setInitialState() {
        return new RequestSpecBuilder()
                .setBaseUri(config().apiBaseUri())
                .setBasePath(config().apiBasePath())
                .setRelaxedHTTPSValidation()
                .build();
    }

    public static RequestSpecification setBody(Object payload) {
        return new RequestSpecBuilder()
                .addRequestSpecification(setInitialState())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBody(payload)
                .build();
    }
}
