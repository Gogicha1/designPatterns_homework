package Steps;

import Pages.FormsPage;
import io.qameta.allure.Step;

public class FormsPageSteps {
    FormsPage formsPage = new FormsPage();

    @Step
    public void clickOnPractice(){
        formsPage.practiceForm.click();
    }
}
