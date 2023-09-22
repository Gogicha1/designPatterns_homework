package WithoutPageFactory.Steps;

import WithoutPageFactory.Pages.FirstPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class FirstSteps {
    WebDriver driver;

    FirstPage firstPage;

    public FirstSteps(WebDriver driver){
        this.driver = driver;
        firstPage = new FirstPage(driver);
    }

    @Step
    public void clickOnMovie(){
        firstPage.getMovieButton().click();
    }
}
