package PageFactory.Steps;

import PageFactory.Pages.MoviesSectionPage;
import io.qameta.allure.Step;
import PageFactory.Pages.MoviesPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class MoviesSteps {
    private MoviesPage moviesPage;
    private MoviesSectionPage moviesSectionPage;
    private WebDriver driver;

    private Actions action;

    private JavascriptExecutor js;



    public MoviesSteps(WebDriver driver){
        this.driver = driver;
        moviesPage = new MoviesPage(driver);
        moviesSectionPage = new MoviesSectionPage(driver);
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @Step ("Checking Movies if has Requested Place in Names and then Clicking on Buy")
    public MoviesSteps clickOnBuy(){
        for (int i = 0; i <= moviesPage.allMovies.size(); i++) {
            WebElement movie = moviesPage.allMovies.get(i);
            action.moveToElement(movie).perform();
            movie.click();

            try {
                js.executeScript("arguments[0].scrollIntoView();" +
                        "arguments[0].click()", moviesSectionPage.eastPoint);
                System.out.println("Movie Is In East-Point");
                break;
            } catch (NoSuchElementException e) {
                driver.navigate().back();
                System.out.println("Movie Is Not In East-Point");
            }
        }
        return this;
    }

}
