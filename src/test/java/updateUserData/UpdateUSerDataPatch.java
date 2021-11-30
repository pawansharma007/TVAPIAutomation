package updateUserData;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

public class UpdateUSerDataPatch {

    @Test
    public void youtubeMethodTrial(){
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void updateUserDataWithPatch(){
        Response response
                =given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .patch("https://reqres.in/api/users/2");

        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getString("updatedAt"));
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test
    public void patchUserData(){
        PatchUserData patchUserData=PatchUserData.builder().name("morpheus").job("zion resident").build();

        Response response=
                given()
                        .body(patchUserData)
                        .patch("https://reqres.in/api/users/2");

        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getString("updatedAt"));
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
