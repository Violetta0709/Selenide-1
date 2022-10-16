package org.veta;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
    @Test
    @DisplayName("Find JUnit5 code on SoftAssertions page")
    @Owner("Veta")
    @Link("https://github.com/")
    void findJUnit5code() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(Condition.text("Welcome to the selenide wiki!"));
        $(Selectors.withText("Soft assertions")).click();
        //$(By.linkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }
}
