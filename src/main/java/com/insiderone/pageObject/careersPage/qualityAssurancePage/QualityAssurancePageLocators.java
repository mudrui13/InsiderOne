package com.insiderone.pageObject.careersPage.qualityAssurancePage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class QualityAssurancePageLocators {
    protected SelenideElement
            pageTitle = $x("//h1[contains(text(),'Quality Assurance')]"),
            seeAllQaJobsButton = $x("//a[text()='See all QA jobs']");
}
