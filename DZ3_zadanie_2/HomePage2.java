package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private SelenideElement searchInput = $("[name='ss']");
    private SelenideElement calendar = $(".xp__dates");
    private SelenideElement searchButton = $(".sb-searchbox__button");

    public HomePage openPage() {
        open("https://www.booking.com/");
        return this;
    }

    public HomePage enterDestination(String destination) {
        searchInput.setValue(destination);
        return this;
    }

    public HomePage selectDates(int checkInOffsetDays, int checkOutOffsetDays) {
        calendar.click();
        SelenideElement checkInDate = $x("//td[@data-date='" + getDate(checkInOffsetDays) + "']");
        checkInDate.click();
        SelenideElement checkOutDate = $x("//td[@data-date='" + getDate(checkOutOffsetDays) + "']");
        checkOutDate.click();
        return this;
    }

    public SearchResultsPage clickSearch() {
        searchButton.click();
        return new SearchResultsPage();
    }

    private String getDate(int offsetDays) {
        java.time.LocalDate date = java.time.LocalDate.now().plusDays(offsetDays);
        return date.toString();
    }
}
 
