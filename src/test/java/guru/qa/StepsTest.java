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
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "Bladgrif/qa_guru_21_demoqa-tests";
    private static final String ISSUE = "second";

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("roman_grigorev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Наличие issue second в репозитории Bladgrif/qa_guru_21_demoqa-tests")
    public void selenideSearchLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        step("Открываем главную страницу Github", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue((REPOSITORY)).submit();
        });
        step("Кликаем по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText(ISSUE)).should(exist);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("roman_grigorev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Наличие issue #1 в репозитории Bladgrif/qa_guru_21_demoqa-tests")
    public void selenideSearchAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainGithubPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}