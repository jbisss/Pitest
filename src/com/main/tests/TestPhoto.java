package com.main.tests;

import com.main.pages.LoginPage;
import com.main.pages.PhotoPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPhoto extends BaseTest {
    /**
     * Проверка на корректное добавление альбома
     */
    private final String PHOTO_DIR = "D:\\Photos\\images\\iKVyQ-LCrsY.jpg";
    @Test
    public void testPhotos() {
        final String setAlbumName = "New album!!!";
        String albumName = new UserPage()
                .goToPhotos()
                .addAlbum()
                .nameAlbum(setAlbumName)
                .createAlbum()
                .goToAlbumsList()
                .findAlbum(setAlbumName);
        assertEquals(setAlbumName, albumName);
    }
    @Test
    public void testPhotoUpload()
    {
        UserPage userPage = new UserPage();
        userPage.goToPhotos();
        PhotoPage photoPage = new PhotoPage();
        var previousCount = photoPage.getPhotoCount();
        photoPage.uploadPhoto(PHOTO_DIR);
        photoPage.waitForUpload(previousCount+1);
        assertEquals(previousCount + 1, photoPage.getPhotoCount(), "Фото не было загружено!");

    }
}
