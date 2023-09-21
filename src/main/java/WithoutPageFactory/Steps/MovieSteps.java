package WithoutPageFactory.Steps;

import WithoutPageFactory.Pages.MoviePage;
import WithoutPageFactory.Pages.SectionsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MovieSteps {
    WebDriver driver;
    MoviePage moviePage;

    Actions action;

    JavascriptExecutor js;

    SectionsPage sectionsPage;


    public MovieSteps(WebDriver driver){
        this.driver = driver;
        moviePage = new MoviePage(driver);
        sectionsPage = new SectionsPage(driver);
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @Step
    public void checkAndBuy(){
        for (int i = 0; i <= moviePage.getMovies().size(); i++) {
            WebElement movie = moviePage.getMovies().get(i);
            action.moveToElement(movie).perform();
            movie.click();

            try {
                js.executeScript("arguments[0].scrollIntoView();" +
                        "arguments[0].click()", sectionsPage.returnEastPoint());
                System.out.println("Movie Is In East-Point");
                break;
            } catch (NoSuchElementException e) {
                driver.navigate().back();
                System.out.println("Movie Is Not In East-Point");
            }
        }
    }
}
