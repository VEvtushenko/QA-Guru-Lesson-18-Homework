package guru.qa.helpers;

import com.codeborne.selenide.WebDriverRunner;
import guru.qa.config.Project;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class DriverUtils {

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static URL getVideoUrl(String sessionId) {
        if (!Project.config.videoURL().equals("")) {
            String videoUrl = Project.config.videoURL() + sessionId + ".mp4";
            try {
                return new URL(videoUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Step("Auth with cookie")
    public static void getAuth(Cookie authCookie) {
            open("/favicon.ico");
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
            open("/");
    }
}
