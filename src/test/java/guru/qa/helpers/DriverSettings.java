package guru.qa.helpers;

import com.codeborne.selenide.Configuration;
import guru.qa.config.Project;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {
    public static void driverConfig() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = Project.config.baseTestedURL();
        RestAssured.baseURI = Project.config.baseTestedURI();
        if (!Project.config.remoteHub().equals("")) {
            Configuration.remote = Project.config.remoteHub();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
