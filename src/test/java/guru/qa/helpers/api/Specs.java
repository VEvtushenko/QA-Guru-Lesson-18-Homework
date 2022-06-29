package guru.qa.helpers.api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static guru.qa.helpers.api.ApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification requestSpec = with()
                            .contentType("application/x-www-form-urlencoded")
                            .filter(withCustomTemplates())
                            .log().all();

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(302)
            .build();


}
