package helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GeneralHelper {

    // This method is to get a value from a response body
    public String getValueFromResponseBody(Response response, String key) {

        String resp = response.body().asString();
        JsonPath js = new JsonPath(resp);
        return js.getString(key);
    }

    // This method is to assert the response's status code
    public void statusCodeAssertion(Response response, int statusCode) {

        response.then().log().all().assertThat().statusCode(statusCode);
        System.out.println("Status code = " + statusCode);
    }
}
