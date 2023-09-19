import Steps.FormsPageSteps;
import Steps.MainPageSteps;
import Steps.PopUpSteps;
import Steps.PracticeFormsSteps;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;


public class RegistrationTest extends ConfigTest{
    MainPageSteps mainPageSteps = new MainPageSteps();
    FormsPageSteps formsPageSteps = new FormsPageSteps();
    PracticeFormsSteps practiceFormsSteps = new PracticeFormsSteps();
    PopUpSteps popUpSteps = new PopUpSteps();


    @Test
    public void registrationTest(){
        open("https://demoqa.com");
        mainPageSteps.clickOnForms();
        formsPageSteps.clickOnPractice();
        practiceFormsSteps.setUserName().setLastName().setGender().setMobileNumber().formSubmit();
        popUpSteps.checkText().checkEquality();
        Assert.assertTrue(popUpSteps.validName, "Not Correct Name!");
        Assert.assertTrue(popUpSteps.validGender, "Not Equal Gender!");
        Assert.assertTrue(popUpSteps.validNumber, "Not Equal Number!");
    }
}
