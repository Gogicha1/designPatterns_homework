package Steps;

import Pages.FirstPage;
import io.qameta.allure.Step;

public class FirstPageSteps {
    FirstPage mainPage = new FirstPage();

    @Step
    public void clickOnForms(){
        mainPage.formsButton.scrollTo().click();
    }

}
