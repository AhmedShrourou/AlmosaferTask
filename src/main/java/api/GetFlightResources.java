package api;

import helper.GeneralHelper;
import helper.PropertiesReader;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class GetFlightResources {

    GeneralHelper generalHelper = new GeneralHelper();
    List<String> cities = Arrays.asList("AMM","DXB","CAI");
    Random rnd = new Random();
    String city;
    public Response flightGetResourcesCall() {

        city = cities.get(rnd.nextInt(cities.size()));
        return given().when().log().all()
                .header("Content-Type", "application/json")
                .baseUri(PropertiesReader.getProperty("url"))
                .relaxedHTTPSValidation()
                .get(PropertiesReader.getProperty("flight-path").replace("{cities}",city));

    }

    public Response flightGetResourcesCall(String cityData) {

        city = cityData;
        return given().when().log().all()
                .header("Content-Type", "application/json")
                .baseUri(PropertiesReader.getProperty("url"))
                .relaxedHTTPSValidation()
                .get(PropertiesReader.getProperty("flight-path").replace("{cities}",city));

    }

    public void flightGetResourcesResponseAssertion(Response response) throws Exception {
        Assert.assertEquals( generalHelper.getValueFromResponseBody(response, "airport[0].code"),city);
        Assert.assertNotNull("Country object is null", generalHelper.getValueFromResponseBody(response, "airport[0].country"));
    }

    public void flightGetResourcesResponseAssertionNegative(Response response) throws Exception {
        Assert.assertNull("airport code should be null", generalHelper.getValueFromResponseBody(response, "airport[0].code"));
        Assert.assertNull("Country object should be null", generalHelper.getValueFromResponseBody(response, "airport[0].country"));
    }
}
