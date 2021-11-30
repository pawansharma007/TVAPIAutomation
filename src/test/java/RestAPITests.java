import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import users.CreateUserRequestBody;
import users.CreateUserResponseBody;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class RestAPITests {

    @Test
    public void getUserDetails()
    {
        System.out.println("Test Run");

        Response response= given()
                .get("https://reqres.in/api/users?page=2");

        System.out.println("Get Users");
        System.out.println(response.asString());
 //       System.out.println(response.jsonPath().prettify());
    }

    @Test
    public void createUser()
    {
        Response response=
                given()
                        .body("{\n" +
                                "    \"name\": \"morpheus\",\n" +
                                "    \"job\": \"leader\"\n" +
                                "}")
                        .post("https://reqres.in/api/users");

        String id=response.jsonPath().getString("id").toString();
        System.out.println(id);
        assertNotNull(id);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void shouldCreateUser()
    {
        CreateUserRequestBody requestBody=CreateUserRequestBody.builder().name("morpheus").job("leader").build();

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .post("https://reqres.in/api/users");


        //  String id=response.jsonPath().getString("id").toString();
        //      assertNotNull(id);

        CreateUserResponseBody createUserResponseBody= response.as(CreateUserResponseBody.class);
       assertNotNull(createUserResponseBody.getId());
       assertEquals(createUserResponseBody.getName(),requestBody.getName());


        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
