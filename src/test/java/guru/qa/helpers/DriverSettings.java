package guru.qa.helpers;

import com.codeborne.selenide.Configuration;
import guru.qa.config.Project;
import io.restassured.RestAssured;

public class DriverSettings {
    public static void driverConfig() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = Project.config.baseTestedURL();
        RestAssured.baseURI = Project.config.baseTestedURI();
        if (!Project.config.remoteHub().equals("")) {
            Configuration.remote = Project.config.remoteHub();
        }
    }
}
