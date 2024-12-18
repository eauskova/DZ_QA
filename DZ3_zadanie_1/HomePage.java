package com.example.tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private SelenideElement searchInput = $("[name='ss']");
    private SelenideElement searchButton = $(".sb-searchbox__button");

    public HomePage openPage() {
        open("https://booking.com/");
        return this;
    }

    public HomePage enterDestination(String destination) {
        searchInput.setValue(destination);
        return this;
    }

    public SearchResultsPage clickSearch() {
        searchButton.click();
        return new SearchResultsPage();
    }
}
 
