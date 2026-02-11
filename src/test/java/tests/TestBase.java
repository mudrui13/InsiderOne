package tests;

import com.codeborne.selenide.Configuration;
import com.insiderone.pageObject.mainPage.MainPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class TestBase {
    protected MainPage mainPage;

    final static String MAIN_PAGE = "https://insiderone.com/";

    @BeforeAll
    public static void setup() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "normal";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void takeScreenshotOnFailure(TestInfo testInfo) {
        screenshot(testInfo.getDisplayName());
    }

    @Step
    public void openMainPage() {
        open(MAIN_PAGE);
        mainPage = new MainPage();
    }
}
