package com.main.tests;

import com.main.pages.LoginPage;
import com.main.pages.PhotoPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPhoto extends BaseTest {
    private final String PHOTO_DIR = "D:\\Photos\\images\\iKVyQ-LCrsY.jpg";
    @DisplayName("Test checks correct photo upload")
    @Test
    public void testPhotoUpload()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(LOGIN, PASSWORD);
        UserPage userPage = new UserPage();
        userPage.goToPhotos();
        PhotoPage photoPage = new PhotoPage();
        var previousCount = photoPage.getPhotoCount();
        photoPage.uploadPhoto(PHOTO_DIR);
        photoPage.waitForUpload(previousCount+1);
        Assertions.assertEquals(previousCount + 1, photoPage.getPhotoCount(), "Фото не было загружено!");
    }
}
