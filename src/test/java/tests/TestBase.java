package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.insiderone.pageObject.careersPage.qualityAssurancePage.QualityAssurancePage;
import com.insiderone.pageObject.mainPage.MainPage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {
    protected MainPage mainPage;
    protected QualityAssurancePage qualityAssurancePage;

    final static String MAIN_PAGE = "https://insiderone.com/";
    final static String QUALITY_ASSURANCE_PAGE = "https://insiderone.com/careers/quality-assurance/";

    @BeforeAll
    public void setup() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "normal";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

    @Step
    public void openMainPage() {
        open(MAIN_PAGE);
        mainPage = new MainPage();
    }

    public void openQualityAssurancePage() {
        open(QUALITY_ASSURANCE_PAGE);
        qualityAssurancePage = new QualityAssurancePage();
    }
}
