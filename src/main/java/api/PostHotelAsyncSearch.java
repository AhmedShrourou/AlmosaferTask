package api;

import helper.GeneralHelper;
import helper.PropertiesReader;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class PostHotelAsyncSearch {

    GeneralHelper generalHelper = new GeneralHelper();

    public Response hotelSearchCall(String body) {

        return given().when().log().all()
                .header("Token", "skdjfh73273$7268u2j89s")
                .header("Content-Type", "application/json")
                .body(body)
                .baseUri(PropertiesReader.getProperty("url"))
                .relaxedHTTPSValidation()
                .post(PropertiesReader.getProperty("hotel-path"));

    }

    public void hotelSearchResponseAssertion(Response response) throws Exception {

        Assert.assertNotNull("SID should not be null", generalHelper.getValueFromResponseBody(response, "sId"));

    }
}
