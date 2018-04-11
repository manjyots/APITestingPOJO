package resources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import utils.Properties;

public class TestApiResource extends BaseResource {

    public TestApiResource(Properties properties) {
        super(properties);
    }

    public Response getApiResponse(String url) {
        RequestSpecification specification = getSpecification(url)
                .header("traceID", RandomStringUtils.random(5));

        Response response = specification.when().get(url);

        System.out.println("Get  Response"+response.asString());

        return response;
    }

    public Response postApiResponse(String url, String body) {
        RequestSpecification specification = getSpecification(url).body(body);

        Response response = specification.when().post(url);

        System.out.println("post  Response"+response.asString());

        return response;
    }
}
