package WithoutPageFactory.Steps;

import PageFactory.Steps.PopUpSteps;
import WithoutPageFactory.Pages.PopUpPage;
import WithoutPageFactory.Pages.SectionsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PopSteps {
    private WebDriver driver;
    private PopUpPage popUpPage;
    private SectionsPage sectionsPage;
    private JavascriptExecutor js;


    public PopSteps(WebDriver driver){
        this.driver = driver;
        popUpPage = new PopUpPage(driver);
        sectionsPage = new SectionsPage(driver);
        js = (JavascriptExecutor) driver;
    }

    @Step
    public PopSteps checkValidity(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(popUpPage.returnPopUpData()));
        String day = sectionsPage.returnData().getText().split(" ")[0];
        String time = sectionsPage.returnTime().get(sectionsPage.returnTime().size()-1).getText().split("\n")[0];
        String concatDayTime = day.concat(time);

        String[] arrPopUpDayTime = popUpPage.returnPopUpData().getText().split(" ");
        String popUpDayTime = arrPopUpDayTime[0].concat(arrPopUpDayTime[2]);

        Assert.assertEquals(sectionsPage.returnMovieName().getText(), popUpPage.returnPopUpName().getText());
        Assert.assertEquals(sectionsPage.returnEastPoint().getText(), popUpPage.returnPopUpLocation().getText());
        Assert.assertEquals(concatDayTime, popUpDayTime);
        return this;
    }

    @Step
    public PopSteps clickOnFreeSeat(){
        js.executeScript("arguments[0].click()", popUpPage.returnFreeSeat());
        return this;
    }
}
