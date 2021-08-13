package commons;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class RestAssuredTest {


    public static Response response;
    public static String messageResponse;
    public static Boolean message;

    public Response postRequest(String apiRequest, File bodyFile)
    {

         response= io.restassured.RestAssured.given().baseUri(apiRequest).contentType(ContentType.JSON).body(bodyFile).post();
         return response;
    }


    public String getJsonValue(String path)
    {
       return  messageResponse= response.then().assertThat().extract().path(path);
    }

    public Boolean getBooleanValue(String path)

    {
        return  message= response.then().assertThat().extract().path(path);
    }

}
