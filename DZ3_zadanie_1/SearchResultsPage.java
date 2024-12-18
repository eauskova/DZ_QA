package com.example.tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage {
    private SelenideElement searchFieldDisplayed = $("[name='ss']");
    private SelenideElement allFiltersButton = $x("//button[contains(text(),'Все фильтры') or contains(text(),'All filters')]");
    private SelenideElement star5Filter = $x("//div[contains(@class,'filteroptions')]//a[contains(@data-filters-item,'class:class=5')]");

    private ElementsCollection hotelCards = $$("div[data-testid='property-card']");

    public SearchResultsPage verifyDestination(String expectedDestination) {
        assertThat(searchFieldDisplayed.getValue()).containsIgnoringCase(expectedDestination);
        return this;
    }

    public SearchResultsPage openAllFilters() {
        allFiltersButton.click();
        return this;
    }

    public SearchResultsPage select5StarsFilter() {
        star5Filter.click();
        return this;
    }

    public SearchResultsPage verifyAllHotelsHave5Stars() {
        for (SelenideElement card : hotelCards) {
            ElementsCollection stars = card.$$("[data-testid='rating-stars'] svg");
            assertThat(stars.size()).isEqualTo(5);
        }
        return this;
    }
}
 
