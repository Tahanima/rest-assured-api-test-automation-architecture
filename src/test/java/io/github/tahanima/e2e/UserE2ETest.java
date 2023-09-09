package io.github.tahanima.e2e;

import static io.github.tahanima.client.UserClient.createUser;
import static io.github.tahanima.client.UserClient.getAllUsers;
import static io.github.tahanima.util.JsonFormatter.prettify;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.tahanima.annotation.DataSource;
import io.github.tahanima.dto.UserDto;
import io.github.tahanima.model.User;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

/**
 * @author tahanima
 */
@Feature("User API Tests")
public class UserE2ETest extends BaseE2ETest {

    private static final String FILE = "user.csv";

    @Story("Successful retrieval of users should return a 200 status code.")
    @DataSource(id = "TC-1", file = FILE, clazz = UserDto.class)
    void testSuccessfulRetrievalOfUsersShouldReturnA200StatusCode(UserDto data) {
        Response response = getAllUsers();

        Allure.attachment("Response Payload", response.asPrettyString());

        assertEquals(SC_OK, Integer.parseInt(data.getOutcome()));
    }

    @Story("Successful creation of user should return a 200 status code and correct response.")
    @DataSource(id = "TC-2", file = FILE, clazz = UserDto.class)
    void testSuccessfulCreationOfUsersShouldReturnA200StatusCodeAndCorrectResponse(UserDto data) {
        User user =
                User.builder()
                        .id(Integer.parseInt(data.getId().trim()))
                        .userName(data.getUserName())
                        .password(data.getPassword())
                        .build();

        Response response = createUser(user);

        Allure.attachment("Request Payload", prettify(user));
        Allure.attachment("Response Payload", response.asPrettyString());

        assertAll(
                () -> assertEquals(SC_OK, Integer.parseInt(data.getOutcome())),
                () -> assertEquals(user, response.as(User.class)));
    }
}
