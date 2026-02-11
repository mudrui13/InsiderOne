package tests.careers;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.TestClasses;

@Epic("Careers")
@Feature("OpenPositionsFilter")
public class Filter extends TestClasses {

    // TODO: this approach is bad - hardcoded values. Better to get dynamic data from dropdowns before each test and
    //  use them as @ParameterizedTest
    private static final String LOCATION = "Istanbul, Turkiye";
    private static final String DEPARTMENT = "Quality Assurance";

    @BeforeEach
    public void openPositionsPageAndSelectFilter(){
        openQualityAssurancePage();
        openPositionsPage = qualityAssurancePage.clickSeeAllQaJobsButton();
        openPositionsPage
                .selectLocation(LOCATION)
                .selectDepartment(DEPARTMENT);
    }

    @Story("Open positions filter - position's job title")
    @Description("Check expected job title for position")
    @Test
    public void checkPositionJobTitle() {
        openPositionsPage.verifyAllPositionsContainsJobTitles(DEPARTMENT);
    }

    @Story("Open positions filter - position's job department")
    @Description("Check expected job department for position")
    @Test
    public void checkPositionJobDepartment() {
        openPositionsPage.verifyAllPositionsContainJobDepartment(DEPARTMENT);
    }

    @Story("Open positions filter - position's job location")
    @Description("Check expected job location for position")
    @Test
    public void checkPositionJobLocation() {
        openPositionsPage.verifyAllPositionsContainJobLocation(LOCATION);
    }
}
