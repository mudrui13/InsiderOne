package tests.careers;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import tests.TestClasses;

@Epic("Careers")
@Feature("OpenPositions-ViewRole")
public class ViewRole extends TestClasses {

    @Story("Check View Role redirect")
    @Description("Click view role button -> check redirect to Lever Application form page")
    @Test
    public void checkViewRoleButtonRedirect(){
        openQualityAssurancePage();
        openPositionsPage = qualityAssurancePage.clickSeeAllQaJobsButton();
        openPositionsPage
                .verifyJobsListPresent()
                .clickFirstViewRole();
        openPositionsPage.verifyLeverPageIsOpened();
    }
}
