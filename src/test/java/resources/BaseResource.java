package resources;

import io.restassured.specification.RequestSpecification;
import utils.Properties;

import static io.restassured.RestAssured.given;

public class BaseResource {

    public Properties properties;

    BaseResource(Properties properties) {
        this.properties = properties;
    }

    protected RequestSpecification getSpecification(String url) {
        return given().request().with()
                .contentType("application/json")
                .header("Accept", "application/json");


    }
}
