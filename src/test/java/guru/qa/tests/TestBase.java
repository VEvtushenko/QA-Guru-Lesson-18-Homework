package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.attachments.AllureAttachments;
import guru.qa.config.Project;
import guru.qa.helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase  {
    @BeforeAll
    static void setupAPITest() {
        DriverSettings.driverConfig();
    }

    @BeforeEach
    void allureListeners() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
    }

    @AfterAll
    static void addAttachments() {
        AllureAttachments.addPageSource();
        AllureAttachments.addScreenshotAs("Final screenshot");
        AllureAttachments.addBrowserLogs();
        if (!Project.config.videoURL().equals("")) {
            AllureAttachments.addVideo();
        }
        Selenide.closeWebDriver();
    }
}
