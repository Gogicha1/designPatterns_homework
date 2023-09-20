package Steps;

import Pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Step
    public void clickOnForms(){
        mainPage.formsButton.scrollTo().click();
    }

}
