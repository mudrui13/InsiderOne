package tests.mainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import tests.TestClasses;

@Epic("MainPage")
@Feature("Blocks")
public class MainPageBlocks extends TestClasses {

    @Story("Main page blocks")
    @Description("Open main page -> check main page is opened -> check main blocks are loaded")
    @Test
    public void checkBlocksInMainPage(){
        openMainPage();
        mainPage
                .verifyTrustedCustomers()
                .verifyFooter()
                .verifyHeaderMenu()
                .verifyHeroSection();
    }

}
