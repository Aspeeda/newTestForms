import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForms {
    String name = "Ivan";
    String surname = "Ivanov";
    String email = "example@example.ru";
    String phNumber = "8123321789";
    String subject = "English";
    String address = "city, street, house 1";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulRegistrationTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(name), text(surname),
                text(email), text(phNumber),text("30 December,1989"), text(subject),text("Sports"),text("1.jpg"),
                text(address), text("NCR Delhi"));
    }
}