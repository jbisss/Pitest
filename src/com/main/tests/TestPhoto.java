package com.main.tests;

import com.main.pages.LoginPage;
import com.main.pages.PhotoPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TestPhoto extends BaseTest {
    private final String PHOTO_DIR = "D:\\Photos\\images\\ben.jpg";
    private boolean photoWasAdded;
    @DisplayName("Test checks correct photo upload")
    @Test
    public void testPhotoUpload()
    {
        photoWasAdded = false;
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(LOGIN, PASSWORD);
        UserPage userPage = new UserPage();
        userPage.goToPhotos();
        PhotoPage photoPage = new PhotoPage();
        var previousCount = photoPage.getPhotoCount();
        photoPage.uploadPhoto(PHOTO_DIR);
        photoPage.waitForUpload(previousCount+1);
        photoWasAdded = previousCount + 1 == photoPage.getPhotoCount();
        Assertions.assertTrue(photoWasAdded, "Фото не было загружено!");
    }
    @AfterEach
    public void removeAddedPhoto()
    {
        if(!photoWasAdded)
            return;

        open("https://ok.ru");
        UserPage userPage = new UserPage();
        userPage.goToPhotos();
        PhotoPage photoPage = new PhotoPage();
        photoPage.goToAlbumSettings("Личные фотографии")
                .goToMenu();
        photoPage.getLastAddedPhoto().click();
    }
}
