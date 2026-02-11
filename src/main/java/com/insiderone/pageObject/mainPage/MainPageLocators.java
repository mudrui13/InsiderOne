package com.insiderone.pageObject.mainPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageLocators {
    protected SelenideElement
            pageTitle = $x("//h1[contains(text(),'unstoppable')]"),
            headerMenu = $x("//header[@id='navigation']"),
            heroSection = $x("//div[@class='homepage-hero-wrapper']"),
            trustedCustomers = $x("//h2[contains(text(),'TRUSTED BY')]"),
            footer = $x("//*[@id='footer']");
}
