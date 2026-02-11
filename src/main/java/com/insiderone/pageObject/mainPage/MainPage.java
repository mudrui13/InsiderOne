package com.insiderone.pageObject.mainPage;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class MainPage extends MainPageLocators {

    public MainPage(){
        pageTitle.shouldBe(visible);
    }

    //assertions block
    @Step
    public MainPage verifyHeaderMenu() {
        headerMenu.shouldBe(visible);
        return this;
    }

    @Step
    public MainPage verifyHeroSection() {
        heroSection.shouldBe(visible);
        return this;
    }

    @Step
    public MainPage verifyTrustedCustomers() {
        trustedCustomers.shouldBe(visible);
        return this;
    }

    @Step
    public MainPage verifyFooter() {
        footer.shouldBe(visible);
        return this;
    }
}
