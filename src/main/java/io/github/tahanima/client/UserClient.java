package io.github.tahanima.client;

import static io.github.tahanima.util.Endpoint.USER;
import static io.github.tahanima.util.RequestSpec.setBody;
import static io.github.tahanima.util.RequestSpec.setInitialState;
import static io.restassured.RestAssured.given;

import io.github.tahanima.model.User;
import io.restassured.response.Response;

/**
 * @author tahanima
 */
public final class UserClient {

    private UserClient() {}

    public static Response getAllUsers() {
        return given().spec(setInitialState()).when().get(USER);
    }

    public static Response createUser(User user) {
        return given().spec(setBody(user)).when().post(USER);
    }

    public static Response getUserById(int id) {
        return given().spec(setInitialState()).when().get(USER, id);
    }

    public static Response updateUserById(User user, int id) {
        return given().spec(setBody(user)).when().put(USER, id);
    }

    public static Response deleteUserById(int id) {
        return given().spec(setInitialState()).when().delete(USER, id);
    }
}
