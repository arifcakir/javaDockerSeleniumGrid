package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RestAssuredHelper {
    public static int getStatusCodeForGetRequest(String URL) {
        return RestAssured.get(URL).getStatusCode();
    }

    public static int getStatusCodeForPostRequest(String URL) {
        return RestAssured.post(URL).getStatusCode();
    }

    public static long getResponseTimeForGetRequest(String URL) {
        Response response = RestAssured.given().get(URL);
        return response.getTime();
    }
    public static long getResponseTimeForPostRequest(String URL) {
        Response response = RestAssured.given().get(URL);
        return response.getTime();
    }
}
