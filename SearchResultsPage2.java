package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage {
    private SelenideElement showOnMapButton = $x("//button[contains(text(),'Показать на карте') or contains(text(),'Show on map')]");

    public MapViewPage showOnMap() {
        showOnMapButton.click();
        return new MapViewPage();
    }
}
 
