package guru.qa.helpers.api;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static guru.qa.data.TestData.*;
import static guru.qa.helpers.api.ApiListener.withCustomTemplates;
import static guru.qa.helpers.api.Specs.requestSpec;
import static guru.qa.helpers.api.Specs.responseSpec;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ApiRequests {

    public static Cookie getAuthCookie(String authCookieName) {
        String authCookieValue = given()
                .spec(requestSpec)
                .when()
//                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", login)
                .formParam("Password", password)
                .formParam("RememberMe", "true")
//                .body(loginRequest)
                .post("/login")
                .then()
                .spec(responseSpec)
                .extract().cookie(authCookieName);
        return new Cookie(authCookieName, authCookieValue);
    }

    @Step("Add product to cart")
    public static String addToCart(Cookie authCookie) {
        return given()
                .filter(withCustomTemplates())
                .when()
                .cookie(String.valueOf(authCookie))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(addComputerRequest)
                .post("/addproducttocart/details/74/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("updatetopcartsectionhtml", notNullValue())
                .extract().body().jsonPath().getString("message");
    }

    public static void addUserAddress(Cookie authCookie) {
        given()
                .spec(requestSpec)
                .when()
                .cookie(String.valueOf(authCookie))
//                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(addAddressRequest)
                .post("/customer/addressadd")
                .then()
                .spec(responseSpec);
    }
}
