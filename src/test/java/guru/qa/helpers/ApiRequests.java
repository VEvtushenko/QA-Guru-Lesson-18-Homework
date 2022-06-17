package guru.qa.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static guru.qa.data.TestData.*;
import static guru.qa.helpers.ApiListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class ApiRequests {
    @Step("Get auth cookie")
    public static Cookie getAuthCookie(String authCookieName) {
        String authCookieValue = given()
                .filter(withCustomTemplates())
                .log().all()
                .when()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", login)
                .formParam("Password", password)
                .formParam("RememberMe", "true")
//                .body(loginRequest)
                .post("/login")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookie(authCookieName);
        return new Cookie(authCookieName, authCookieValue);
    }

    @Step("Add product to cart")
    public static String addToCart(String authCookieValue) {
        return given()
                .filter(withCustomTemplates())
                .when()
                .cookie(authCookieValue)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(addComputerRequest)
                .post("/addproducttocart/details/74/1")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().toString();
    }
}
