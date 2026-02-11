package com.insiderone.pageObject.careersPage.openPositionsPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class OpenPositionsPageLocators {
    protected SelenideElement
            pageTitle = $x("//h3[text()='All open positions']"),
            locationDropDown = $x("//select[@id='filter-by-location']"),
            departmentDropDown = $x("//select[@id='filter-by-department']"),
            jobsList = $x("//div[@id='jobs-list']");

    protected ElementsCollection
            jobTitles = $$x("//p[contains(@class,'position-title')]"),
            jobDepartments = $$x("//span[contains(@class,'position-department')]"),
            jobLocations = $$x("//div[contains(@class,'position-location')]"),
            viewRoleButtons = $$x("//a[text()='View Role']");
}
