package guru.qa.helpers;

import guru.qa.config.Project;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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

}
