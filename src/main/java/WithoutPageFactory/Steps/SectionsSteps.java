package WithoutPageFactory.Steps;

import PageFactory.Steps.MoviesSectionSteps;
import WithoutPageFactory.Pages.SectionsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;

public class SectionsSteps {
    WebDriver driver;
    SectionsPage sectionsPage;
    JavascriptExecutor js;
    public SectionsSteps(WebDriver driver){
        this.driver = driver;
        sectionsPage = new SectionsPage(driver);
        js = (JavascriptExecutor) driver;

    }

    @Step
    public SectionsSteps clickOnLastDay(){
        js.executeScript("arguments[0].scrollIntoView();" + "arguments[0].click()", sectionsPage.returnData());
        return this;
    }

    @Step
    public SectionsSteps checkEastPoint(){
        Iterator<WebElement> iterator = sectionsPage.returnSeances().iterator();
        while (iterator.hasNext()) {
            WebElement seance = iterator.next();
            if (seance.getText().isEmpty()){
                iterator.remove();
            }else {
                Assert.assertEquals(seance.getText(), "კავეა ისთ ფოინთი");
            }
        }
        return this;
    }

    @Step
    public SectionsSteps clickOnLastSeance(){
        WebElement lastSeance = sectionsPage.returnSeances().get(sectionsPage.returnSeances().size() - 1);
        js.executeScript("arguments[0].click()", lastSeance);
        return this;
    }
}
