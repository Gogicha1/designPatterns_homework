import PageFactory.Steps.MainPageSteps;
import PageFactory.Steps.MoviesSectionSteps;
import PageFactory.Steps.MoviesSteps;
import PageFactory.Steps.PopUpSteps;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({ListenerConfig.class})
@Epic("Test of Booking Ticket on Swoop")
@Feature("Using Click Methods and Assertions")

public class SwoopTestPageFactory extends SeleniumConfig {

    private MainPageSteps mainPageSteps;
    private MoviesSteps moviesSteps;
    private MoviesSectionSteps moviesSectionSteps;
    private PopUpSteps popUpSteps;


    @Test(description = "swoop test")
    @Story("User Choosing Movie, Seance and Booking it")
    @Description("Test for Swoop Choosing Movie Which has Seance" +
            " in Specific Cinema Place And Make Booking")
    @Severity(SeverityLevel.NORMAL)

    public void swoopTestPageFactory(){
        mainPageSteps = new MainPageSteps(driver);
        moviesSteps = new MoviesSteps(driver);
        moviesSectionSteps = new MoviesSectionSteps(driver);
        popUpSteps = new PopUpSteps(driver);

        mainPageSteps.clickOnMovieButton();
        moviesSteps.clickOnBuy();
        moviesSectionSteps.clickOnLastDate().checkEastPoint("კავეა ისთ ფოინთი").clickOnLastOption();
        popUpSteps.checkEquality().clickOnFreeSeat();

        Assert.fail();
    }
}
