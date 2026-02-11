package com.insiderone.pageObject.careersPage.openPositionsPage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class OpenPositionsPage extends OpenPositionsPageLocators {

    public OpenPositionsPage() {
        pageTitle.shouldBe(visible);
        viewRoleButtons.first().shouldBe(visible);
    }

    @Step("Select location: {location}")
    public OpenPositionsPage selectLocation(String location) {
        String htmlBefore = getJobsListHtml();
        selectByValue(locationDropDown, location);
        waitForJobsListUpdate(htmlBefore);
        return this;
    }

    @Step("Select department: {department}")
    public OpenPositionsPage selectDepartment(String department) {
        selectByValue(departmentDropDown, department);
        return this;
    }

    @Step("Click View Role button")
    public void clickFirstViewRole() {
        viewRoleButtons.first().click();
    }

    //assertions
    @Step("Verify jobs list is present")
    public OpenPositionsPage verifyJobsListPresent() {
        jobsList.shouldBe(visible);
        return this;
    }

    @Step("Verify all positions contain: {expectedJobTitle}")
    public OpenPositionsPage verifyAllPositionsContainsJobTitles(String expectedJobTitle) {
        jobTitles.stream().forEach(
                t -> t.shouldHave(text(expectedJobTitle)));
        return this;
    }

    @Step("Verify all departments contain: {expectedJobDepartment}")
    public OpenPositionsPage verifyAllPositionsContainJobDepartment(String expectedJobDepartment) {
        jobDepartments.stream().forEach(
                d -> d.shouldHave(text(expectedJobDepartment)));
        return this;
    }

    @Step("Verify all locations contain: {expectedJobLocation}")
    public OpenPositionsPage verifyAllPositionsContainJobLocation(String expectedJobLocation) {
        jobLocations.stream().forEach(
                l -> l.shouldHave(text(expectedJobLocation)));
        return this;
    }

    @Step("Verify Lever page opened")
    public void verifyLeverPageIsOpened() {
        Selenide.switchTo().window(1);
        Selenide.Wait().until(driver ->
                WebDriverRunner.url().contains("jobs.lever.co"));
    }

    //private methods
    private void selectByValue(SelenideElement select, String value) {
        Selenide.executeJavaScript(
                "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                select, value);
    }

    private String getJobsListHtml() {
        return jobsList.innerHtml();
    }

    private void waitForJobsListUpdate(String htmlBefore) {
        Selenide.Wait().until(driver -> !jobsList.innerHtml().equals(htmlBefore));
    }
}
