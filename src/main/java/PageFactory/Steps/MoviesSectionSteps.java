package PageFactory.Steps;

import PageFactory.Pages.MoviesSectionPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;


public class MoviesSectionSteps {
    private WebDriver driver;
    private JavascriptExecutor js;
    private MoviesSectionPage moviesSectionPage;

    public MoviesSectionSteps(WebDriver driver){
        this.driver = driver;
        moviesSectionPage = new MoviesSectionPage(driver);
        js = (JavascriptExecutor) driver;
    }

    @Step("Clicking on Last Suggested Date")
    public MoviesSectionSteps clickOnLastDate(){
        js.executeScript("arguments[0].scrollIntoView();" + "arguments[0].click()", moviesSectionPage.date);
        return this;
    }

    @Step ("Assertion of Cinema names with {0}")
    public MoviesSectionSteps checkEastPoint(String theatreName){
        Iterator<WebElement> iterator = moviesSectionPage.eastPointSeances.iterator();
        while (iterator.hasNext()) {
            WebElement seance = iterator.next();
            if (seance.getText().isEmpty()){
                iterator.remove();
            }else {
                Assert.assertEquals(seance.getText(), theatreName);
            }
        }
        return this;
    }

    @Step ("Clicking on Last Seance")
    public MoviesSectionSteps clickOnLastOption(){
        WebElement lastSeance = moviesSectionPage.eastPointSeances.get(moviesSectionPage.eastPointSeances.size() - 1);
        js.executeScript("arguments[0].click()", lastSeance);
        return this;
    }
}
