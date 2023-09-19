package Pages;

import Data.RegisterData;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PracticeForms {

    RegisterData registerData = new RegisterData();
    public SelenideElement
            nameItem = $(By.id("firstName")),
            lastNameItem = $(By.id("lastName")),
            gender = $(("input[value='"+registerData.genderData+"']")),
            mobileNumberItem = $(By.id("userNumber")),
            submitButton = $("#submit");
}
