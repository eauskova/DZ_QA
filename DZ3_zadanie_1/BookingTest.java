package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.example.tests.pages.HomePage;
import com.example.tests.pages.SearchResultsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

@Epic("Booking Tests")
@Feature("Hotel Search")
public class BookingTest {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide",
            new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Test
    @Story("Search and filter hotels")
    @Description("Проверяем поиск по «Анталья» и фильтрацию отелей по 5 звёздам")
    @Severity(SeverityLevel.CRITICAL)
    public void testSearchAndFilter5StarsHotels() {
        new HomePage()
                .openPage()
                .enterDestination("Анталья")
                .clickSearch()
                .verifyDestination("Анталья")
                .openAllFilters()
                .select5StarsFilter()
                .verifyAllHotelsHave5Stars();

        closeWebDriver();
    }
}
 
