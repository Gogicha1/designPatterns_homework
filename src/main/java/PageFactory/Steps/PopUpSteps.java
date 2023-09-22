package PageFactory.Steps;

import PageFactory.Pages.MoviesSectionPage;
import PageFactory.Pages.PopUpPages;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PopUpSteps {
    private PopUpPages popUpPages;

    private MoviesSectionPage moviesSectionPage;

    private WebDriver driver;
    private JavascriptExecutor js;

    private WebDriverWait wait;

    public PopUpSteps(WebDriver driver){
        this.driver = driver;
        popUpPages = new PopUpPages(driver);
        moviesSectionPage = new MoviesSectionPage(driver);
        js = (JavascriptExecutor) driver;

    }


    @Step
    public PopUpSteps checkEquality(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(popUpPages.checkData));
        String day = moviesSectionPage.date.getText().split(" ")[0];
        String time = moviesSectionPage.time.get(moviesSectionPage.time.size()-1).getText().split("\n")[0];
        String concatDayTime = day.concat(time);

        String[] arrPopUpDayTime = popUpPages.checkData.getText().split(" ");
        String popUpDayTime = arrPopUpDayTime[0] + arrPopUpDayTime[2];


        Assert.assertEquals(moviesSectionPage.movieName.getText(), popUpPages.popUpName.getText());
        Assert.assertEquals(moviesSectionPage.eastPoint.getText(), popUpPages.popUpLocationName.getText());
        Assert.assertEquals(concatDayTime, popUpDayTime);
        return this;
    }

    @Step
    public PopUpSteps clickOnFreeSeat(){
        js.executeScript("arguments[0].click()", popUpPages.freeSeat);
        return this;
    }
}
