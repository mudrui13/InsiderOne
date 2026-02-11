package com.insiderone.pageObject.careersPage.qualityAssurancePage;

import com.insiderone.pageObject.careersPage.openPositionsPage.OpenPositionsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class QualityAssurancePage extends QualityAssurancePageLocators {

    public QualityAssurancePage(){
        pageTitle.shouldBe(visible);
    }

    @Step
    public OpenPositionsPage clickSeeAllQaJobsButton(){
        seeAllQaJobsButton.click();
        return new OpenPositionsPage();
    }
}
