package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Vlad");
        $("#userEmail").setValue("vlad@evtupage.com");
        $("#currentAddress").setValue("Some street 11");
        $("#permanentAddress").setValue("Another street 11");
        $("#submit").click();

        $("#output #name").shouldHave(text("Vlad"));
        $("#output #email").shouldHave(text("vlad@evtupage.com"));
        $("#output #currentAddress").shouldHave(text("Some street 11"));
        $("#output #permanentAddress").shouldHave(text("Another street 11"));

    }

}
