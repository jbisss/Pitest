package com.main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserPage {
    private final SelenideElement PHOTO_BUTTON = $(By.xpath("//*[@data-l=\"t,userPhotos\"]"));

    /**
     * Нажимает на кнопку "фото"
     *
     * @return новый PhotoPage
     */
    public PhotoPage goToPhotos(){
        PHOTO_BUTTON.shouldBe(Condition.visible.because("Нет кнопки!!")).click();
        return new PhotoPage();
    }
}
