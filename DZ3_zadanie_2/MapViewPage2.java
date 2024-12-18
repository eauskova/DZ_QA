package com.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import static com.codeborne.selenide.Selenide.*;

public class MapViewPage {
    private ElementsCollection hotelCards = $$("div[data-testid='property-card']");
    private ElementsCollection mapMarkers = $$("button[class*='map_marker']");

    public MapViewPage hoverOnFirstHotelCardAndSaveInfo(HotelInfo hotelInfo) {
        SelenideElement firstHotelCard = hotelCards.first();
        Actions actions = new Actions(webdriver());
        actions.moveToElement(firstHotelCard.toWebElement()).perform();

        String hotelName = firstHotelCard.$("[data-testid='title']").getText();
        int starCount = firstHotelCard.$$("[data-testid='rating-stars'] svg").size();
        String reviewData = firstHotelCard.$("[data-testid='review-score']").getText();
        String[] parts = reviewData.split(" ");
        String averageScore = parts[0];
        String reviewsCount = parts[1].replaceAll("[^0-9]", "");
        String price = firstHotelCard.$("[data-testid='price-and-discounted-price'] span").getText();

        hotelInfo.setName(hotelName);
        hotelInfo.setStars(starCount);
        hotelInfo.setAverageScore(averageScore);
        hotelInfo.setReviewsCount(reviewsCount);
        hotelInfo.setPrice(price);

        return this;
    }

    public HotelPage clickCorrespondingMarker(HotelInfo hotelInfo) {
        mapMarkers.first().click();
        return new HotelPage();
    }
}
 
