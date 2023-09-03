package testCases;

import api.PostHotelAsyncSearch;
import helper.DateHelper;
import helper.GeneralHelper;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class HotelAsyncSearchTestCase {

    JSONObject APIBody = new JSONObject();
    DateHelper dateHelper = new DateHelper();
    PostHotelAsyncSearch postHotelAsyncSearch = new PostHotelAsyncSearch();
    GeneralHelper generalHelper = new GeneralHelper();
    @Test
    public void HotelAsyncSearchHappyCase() throws Exception{

        JSONArray roomInfo = new JSONArray();
        JSONObject roomObject = new JSONObject();
        String[] kidsAges = {};

        roomObject.put("adultsCount", 2);
        roomObject.put("kidsAges", kidsAges);
        roomInfo.put(roomObject);
        APIBody.put("checkIn",dateHelper.getDateAfterDays(10));
        APIBody.put("checkOut",dateHelper.getDateAfterDays(12));
        APIBody.put("query","amman");
        APIBody.put("roomsInfo",roomInfo);

        Response response = postHotelAsyncSearch.hotelSearchCall(APIBody.toString());
        generalHelper.statusCodeAssertion(response,200);
        postHotelAsyncSearch.hotelSearchResponseAssertion(response);

    }


    @Test
    public void HotelAsyncSearchNegativeCase() throws Exception{

        JSONArray roomInfo = new JSONArray();
        JSONObject roomObject = new JSONObject();
        String[] kidsAges = {};

        roomObject.put("adultsCount", 2);
        roomObject.put("kidsAges", kidsAges);
        roomInfo.put(roomObject);
        APIBody.put("checkIn",dateHelper.getDateAfterDays(10));
        APIBody.put("checkOut",dateHelper.getDateAfterDays(9));
        APIBody.put("query","amman");
        APIBody.put("roomsInfo",roomInfo);

        Response response = postHotelAsyncSearch.hotelSearchCall(APIBody.toString());
        generalHelper.statusCodeAssertion(response,400);
        Assert.assertEquals( generalHelper.getValueFromResponseBody(response, "error"),"Bad Request");
        Assert.assertEquals( generalHelper.getValueFromResponseBody(response, "code"),"106");

    }
}
