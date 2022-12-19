package com.main.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserPage {
    private final SelenideElement photoButton = $(By.xpath("//*[@data-l=\"t,userPhotos\"]"));

    public void goToPhotos()
    {
        photoButton.click();
    }
}
