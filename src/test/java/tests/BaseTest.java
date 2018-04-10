package tests;

import categories.SanityTest;
import entities.api.UserDetails;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import requestBuilder.UserDetailsBuilder;
import resources.TestApiResource;
import utils.Properties;
import utils.RequestHelper;
import utils.ResponseHelper;

import java.io.IOException;

public class
BaseTest {
    private Properties properties ;

    public BaseTest() {
        properties= new Properties();
    }



    @Test
    @Category(SanityTest.class)
    public void verifyGetApi() throws IOException {

        String url = properties.baseUrl+"/users";

        System.out.println("GetApiURL  :  " + url);

        TestApiResource testApiResource = new TestApiResource(properties);

        Response response= testApiResource.getApiResponse(url);

        Assert.assertEquals(200,response.getStatusCode());

        UserDetails userDetailsResponse = (UserDetails)ResponseHelper.getResponseObject(response.asString(),UserDetails.class);

        Assert.assertNotNull(userDetailsResponse);
    }

    @Test
    @Category(SanityTest.class)
    public void verifyPostApi() throws IOException {

        String url = properties.baseUrl+"/users";

        System.out.println("GetApiURL  :  " + url);

        TestApiResource testApiResource = new TestApiResource(properties);

        UserDetails userDetails = new UserDetailsBuilder().build();

        Response response= testApiResource.postApiResponse(url, RequestHelper.asString(userDetails));

        Assert.assertEquals(200,response.getStatusCode());

    }

}
