import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PracticeTest {

    @Test
    public void lottoTest()
    {
        Response response=
                given()
                        .body(" {\n" +
                                "\"lotto\":\n" +
                                "{ \n" +
                                "    \"lottoId\":5,\n" +
                                " \"winning-numbers\":[2,45,34,23,7,5,3],\n" +
                                " \"winners\":[{ \"winnerId\":23, \n" +
                                "\"numbers\":[2,45,34,23,3,5] },\n" +
                                "{ \"winnerId\":54, \n" +
                                "\"numbers\":[52,3,12,11,18,22] }] \n" +
                                "}\n" +
                                " }\n")
                        .get("http://localhost:8080/lotto");

        String lottoId=response.jsonPath().get("lottoId").toString();
        String winnerId=response.jsonPath().get("winnerId").toString();
        String numbers=response.jsonPath().get("numbers").toString();
        Assert.assertEquals(lottoId,5);
        Assert.assertEquals(winnerId, 23);
        Assert.assertEquals(numbers,"2,45,34,23,7,5,3");
    }


}
