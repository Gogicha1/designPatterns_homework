package Steps;

import Data.RegisterData;
import Pages.PopUp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class PopUpSteps {
    PopUp popUp = new PopUp();
    RegisterData registerData = new RegisterData();

    public boolean validName = false;
    public boolean validGender = false;
    public boolean validNumber = false;
    @Step
    public PopUpSteps checkText(){
        popUp.thanksText.should(appear);
        return this;
    }

    @Step
    public void checkEquality(){
        for (SelenideElement selenideElement : popUp.valueTd) {
            if (selenideElement.getText().equalsIgnoreCase( registerData.userName+ " " + registerData.lastName)) {
                validName = true;
            }
            if (selenideElement.getText().equalsIgnoreCase( registerData.genderData)) {
                validGender = true;
            }
            if (selenideElement.getText().equalsIgnoreCase( registerData.mobileNumber)) {
                validNumber = true;
            }
        }
    }

}
