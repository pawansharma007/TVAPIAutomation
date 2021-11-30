package updateUserData;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertNotNull;

public class SingleUserUpdate {

    @Test
    public void updateUserData(){

       Response response=
               given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .put("https://reqres.in/api/users/2");

        System.out.println(response.asString());
        System.out.println("-----------------");
        System.out.println(response.jsonPath().prettify());
        System.out.println("Status Code: " +response.getStatusCode());
        System.out.println("Updated At: " +response.jsonPath().getString("updatedAt").toString());


    }

    @Test
    public void updateUser(){

        UpdateUserData userData=UpdateUserData.builder().name("morpheus").job("zion resident").build();

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .body(userData)
                        .put("https://reqres.in/api/users/2");

        System.out.println(response.asString());
        System.out.println(response.jsonPath().getString("updatedAt"));

        System.out.println("----------");
        UserResponseData userResponseData=response.as(UserResponseData.class);

        assertNotNull(userResponseData.getUpdatedAt());
    }
}
