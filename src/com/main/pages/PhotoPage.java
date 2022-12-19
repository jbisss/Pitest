package com.main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PhotoPage {
    private final SelenideElement ADD_ALBUM_BUTTON = $(By.xpath("//*[@class=\"button-pro __sec __small\"]"));
    private final SelenideElement ALBUM_TEXT_AREA = $(By.xpath("//*[@name=\"st.layer.photoAlbumName\"]"));
    private final SelenideElement CREATE_ALBUM_BUTTON = $(By.xpath("//*[@data-l=\"t,confirm\"]"));
    private final SelenideElement PHOTO_BUTTON = $(By.xpath("//*[@data-l=\"t,userPhotos\"]"));
    private final ElementsCollection ALBUM_TITLE_LIST = $$(By.xpath("//*[@class=\"title__x4tyv\"]"));

    /**
     * Нажимает на кнопку добавления альбома
     *
     * @return возвращает текущую страницу
     */
    public PhotoPage addAlbum(){
        ADD_ALBUM_BUTTON.shouldBe(Condition.visible.because("No button!!!")).click();
        return this;
    }

    /**
     * Нажимает на кнопку "фото"
     *
     * @return возвращает текущую страницу
     */
    public PhotoPage goToAlbumsList(){
        PHOTO_BUTTON.shouldBe(Condition.visible.because("No button!!!")).click();
        return this;
    }

    /**
     * Задаёт название альбому
     *
     * @param albumName название альбома
     * @return возвращает текущую страницу
     */
    public PhotoPage nameAlbum(String albumName){
        ALBUM_TEXT_AREA.shouldBe(Condition.visible.because("No field!!!")).setValue(albumName);
        return this;
    }

    /**
     * Производит поиск названия в "тайтлах" альбомов
     *
     * @param albumName название альбома
     * @return возвращает название альбома, если находит или null
     */
    public String findAlbum(String albumName){
        ALBUM_TITLE_LIST.get(0).shouldBe(Condition.visible);
        for (SelenideElement album : ALBUM_TITLE_LIST){
            if (album.shouldBe(Condition.visible).getText().equals(albumName)) {
                return album.getText();
            }
        }
        return null;
    }

    /**
     * Нажатие на кнопку создания альбома
     *
     * @return возвращает текущую страницу
     */
    public PhotoPage createAlbum(){
        CREATE_ALBUM_BUTTON.shouldBe(Condition.visible.because("No button!!!")).click();
        return this;
    }
}
