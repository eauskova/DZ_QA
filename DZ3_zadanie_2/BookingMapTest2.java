package com.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.pages.HomePage;
import com.example.pages.HotelInfo;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@Epic("Booking Tests")
@Feature("Map Interaction")
public class BookingMapTest {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide",
            new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Test
    @Story("Select city, set random dates, show on map, verify hotel data")
    @Description("Checking hotel data consistency between map card and hotel page")
    @Severity(SeverityLevel.CRITICAL)
    public void testHotelInfoOnMap() {
        HotelInfo hotelInfo = new HotelInfo();

        new HomePage()
                .openPage()
                .enterDestination("Paris")
                .selectDates(30, 32)
                .clickSearch()
                .showOnMap()
                .hoverOnFirstHotelCardAndSaveInfo(hotelInfo)
                .clickCorrespondingMarker(hotelInfo)
                .verifyHotelInfo(hotelInfo);

        closeWebDriver();
    }
}

