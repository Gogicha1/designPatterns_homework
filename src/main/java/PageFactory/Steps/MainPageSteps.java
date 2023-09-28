package PageFactory.Steps;

import io.qameta.allure.Step;
import PageFactory.Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPageSteps {
    private WebDriver driver;
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver){
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

    @Step("Click on Navigation Button to Movies Page")
    public MainPageSteps clickOnMovieButton(){
        mainPage.movieButton.click();
        return this;
    }
}
