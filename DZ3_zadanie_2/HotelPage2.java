package com.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HotelPage {
    private SelenideElement hotelNameHeader = $("[data-testid='title']");
    private ElementsCollection hotelStars = $$("[data-testid='rating-stars'] svg");
    private SelenideElement averageScoreElement = $("[data-testid='review-score-rating']");
    private SelenideElement reviewsCountElement = $("[data-testid='review-score-subtext']");
    private SelenideElement priceElement = $("[data-testid='price-and-discounted-price'] span");

    public HotelPage verifyHotelInfo(HotelInfo expectedInfo) {
        String actualName = hotelNameHeader.getText();
        int actualStars = hotelStars.size();
        String actualScore = averageScoreElement.getText().trim();
        String actualReviewsCount = reviewsCountElement.getText().replaceAll("[^0-9]", "");
        String actualPrice = priceElement.getText();

        assertThat(actualName).containsIgnoringCase(expectedInfo.getName());
        assertThat(actualStars).isEqualTo(expectedInfo.getStars());
        assertThat(actualScore).isEqualTo(expectedInfo.getAverageScore());
        assertThat(actualReviewsCount).isEqualTo(expectedInfo.getReviewsCount());
        assertThat(actualPrice).isEqualTo(expectedInfo.getPrice());

        return this;
    }
}
