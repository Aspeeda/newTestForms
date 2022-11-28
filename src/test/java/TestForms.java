import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TestForms extends TestBase {
    String name = "Ivan";
    String surname = "Ivanov";
    String email = "example@example.ru";
    String phNumber = "8123321789";
    String subject = "English";
    String address = "city, street, house 1";
    String gender = "Male";
    String day = ("30");
    String month = ("December");
    String year = ("1989");
    String hobby = "Sports";
    String state = "NCR";
    String city = "Delhi";
    String picPath = "1.jpg";
    // можно сделать модель данных
    @Test
    void successfulRegistrationTest() {
        RegistrationPage page = new RegistrationPage();

        /**Открытие страницы и заполнение полей*/
        page.openPage()
                .setName(name)
                .setSurName(surname)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phNumber)
                .setBirthdate(day, month, year)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPic("img/"+picPath)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .clickSubmit();

        /**Проверка значений*/
        page.verifyResultsModalAppears()
                .verifyResult("Student Name", name + " " + surname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picPath)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}