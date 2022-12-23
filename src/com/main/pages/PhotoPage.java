package com.main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PhotoPage extends LoadablePage {
    private final ElementsCollection ALBUM_SETTINGS = $$(By.xpath("//*[@class=\"title__x4tyv\"]/../../div"));
    private final SelenideElement ADD_ALBUM_BUTTON = $(By.xpath("//*[@class=\"button-pro __sec __small\"]"));
    private final SelenideElement MENU_ALBUM_BUTTON = $(By.xpath("//*[@class=\"menu-item__qx66s\"]"));
    private final SelenideElement DELETE_ALBUM_BUTTON = $(By.xpath("//*[@class=\"button-pro __sec __small\"]"));
    private final SelenideElement APPROVE_DELETE_ALBUM_BUTTON = $(By.xpath("//*[@data-l=\"t,confirm\"]"));
    private final SelenideElement ALBUM_TEXT_AREA = $(By.xpath("//*[@name=\"st.layer.photoAlbumName\"]"));
    private final SelenideElement CREATE_ALBUM_BUTTON = $(By.xpath("//*[@data-l=\"t,confirm\"]"));
    private final SelenideElement PHOTO_BUTTON = $(By.xpath("//*[@data-l=\"t,userPhotos\"]"));
    private final ElementsCollection ALBUM_TITLE_LIST = $$(By.xpath("//*[@class=\"title__x4tyv\"]"));

    private final SelenideElement PHOTO_COUNT = $(By.xpath("//a[text()=\"Личные фотографии\"]/../../div[@data-l=\"t,info\"]/div"));
    private final SelenideElement UPLOAD_BUTTON = $(By.xpath("//span[@data-l=\"t,upload-new-photo\"]//input"));
    public void approveDeletion(){
        APPROVE_DELETE_ALBUM_BUTTON.shouldBe(Condition.visible).click();
    }
    public PhotoPage deleteAlbum(){
        DELETE_ALBUM_BUTTON.shouldBe(Condition.visible).click();
        return this;
    }
    public PhotoPage goToMenu(){
        MENU_ALBUM_BUTTON.shouldBe(Condition.visible).click();
        return  this;
    }
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
    public int findAlbum(String albumName){
        checkPage();
        int i = 0;
        for (SelenideElement album : ALBUM_TITLE_LIST){
            if(album.shouldBe(Condition.visible).getText().equals(albumName)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public SelenideElement getALBUM_SETTINGS(int index) {
        return ALBUM_SETTINGS.get(index);
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
    /**
     * Загружает фото на сайт
     *
     * @return возвращает текущую страницу
     */
    public PhotoPage uploadPhoto(String photoDir){
        UPLOAD_BUTTON.setValue(photoDir);
        return this;
    }
    /**
     * Ждет пока не измениться кол-во загруженных на сайт фотографий
     *
     */
    public void waitForUpload(int expectedCount){
        PHOTO_COUNT.shouldBe(Condition.visible.because("Нет счетчика фото!"))
                .shouldHave(Condition.partialText(Integer.toString(expectedCount)));
    }
    /**
     * Получить кол-во фотографий в профиле
     *
     * @return возвращает текущую страницу
     */
    public int getPhotoCount()
    {
        var res = PHOTO_COUNT.shouldBe(Condition.visible.because("Нет счетчика фото!"))
                .getText().split(" ")[0];
        try{
            Integer.parseInt(res);
        }
        catch (Exception e){
            return 0;
        }
        return Integer.parseInt(res);
    }

    /**
     * Проверяет загружена ли страница
     */
    @Override
    public void checkPage(){
        ALBUM_TITLE_LIST.get(0).shouldBe(Condition.visible);
        System.out.println("Success");
    }
}
