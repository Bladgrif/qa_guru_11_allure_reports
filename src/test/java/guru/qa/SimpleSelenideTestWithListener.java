package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SimpleSelenideTestWithListener {
    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("roman_grigorev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Наличие issue #1 в репозитории Bladgrif/qa_guru_21_demoqa-tests")
    public void selenideSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".search-input-container").click();
        $("#query-builder-test").setValue(("Bladgrif/qa_guru_21_demoqa-tests")).submit();
        $(linkText("Bladgrif/qa_guru_21_demoqa-tests")).click();
        $("#issues-tab").click();
        $(withText("second")).should(exist);

    }
}
