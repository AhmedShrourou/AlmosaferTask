package testCases;

import api.GetFlightResources;
import api.PostHotelAsyncSearch;
import helper.DateHelper;
import helper.GeneralHelper;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class FlightGetTestCase {

    GetFlightResources getFlightResources = new GetFlightResources();
    GeneralHelper generalHelper = new GeneralHelper();
    @Test
    public void FlightGetResourceHappyCase() throws Exception{

        Response response = getFlightResources.flightGetResourcesCall();
        generalHelper.statusCodeAssertion(response,200);
        getFlightResources.flightGetResourcesResponseAssertion(response);

    }

    @Test
    public void FlightGetResourceNegative() throws Exception{

        Response response = getFlightResources.flightGetResourcesCall("asfaffs");
        generalHelper.statusCodeAssertion(response,200);
        getFlightResources.flightGetResourcesResponseAssertionNegative(response);

    }

}
