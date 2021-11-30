import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SearchAPI {

    public void searchText(){
        Response response=
                given()
                        .body("Testvagrant")
                        .get("searchAPIURI");

        System.out.println(response.asString());
    }
}
