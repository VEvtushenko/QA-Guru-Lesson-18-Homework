package guru.qa.helpers.apiRequests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import org.openqa.selenium.Cookie;

import static guru.qa.data.TestData.*;
import static guru.qa.helpers.ApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class GetAuth {
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
                .post(
                        "/login")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookie(authCookieName);
        Cookie authCookie = new org.openqa.selenium.Cookie(authCookieName, authCookieValue);
        return authCookie;
    }

    @Step("Send cookie")
    public static void getAuth(Cookie authCookie) {
        WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
    }
}
