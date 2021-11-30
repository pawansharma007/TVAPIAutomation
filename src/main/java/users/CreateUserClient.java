package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUserClient {

    public CreateUserResponseBody createUser(CreateUserRequestBody requestBody)
    {
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .post("https://reqres.in/api/users");

        int statusCode=response.statusCode();

        CreateUserResponseBody responseBody=response.as(CreateUserResponseBody.class);
        responseBody.setStatusCode(statusCode);
        return responseBody;

    }
}
