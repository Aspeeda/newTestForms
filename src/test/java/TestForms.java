import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestData;

public class TestForms extends TestBase {
    @Test
    void successfulRegistrationTest() {

        /**Открытие страницы и заполнение полей*/
        registrationPage.openPage()
                .setName(TestData.name)
                .setSurName(TestData.surname)
                .setEmail(TestData.email)
                .setGender(TestData.gender)
                .setPhone(TestData.phNumber)
                .setBirthdate(TestData.day, TestData.month, TestData.year)
                .setSubject(TestData.subject)
                .setHobby(TestData.hobby)
                .uploadPic("img/" + TestData.picPath)
                .setAddress(TestData.address)
                .selectState(TestData.state)
                .selectCity(TestData.city)
                .clickSubmit();

        /**Проверка значений*/
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", TestData.name + " " + TestData.surname)
                .verifyResult("Student Email", TestData.email)
                .verifyResult("Gender", TestData.gender)
                .verifyResult("Mobile", TestData.phNumber)
                .verifyResult("Date of Birth", TestData.day + " " + TestData.month + "," + TestData.year)
                .verifyResult("Subjects", TestData.subject)
                .verifyResult("Hobbies", TestData.hobby)
                .verifyResult("Picture", TestData.picPath)
                .verifyResult("Address", TestData.address)
                .verifyResult("State and City", TestData.state + " " + TestData.city);
    }
}