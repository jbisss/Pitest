package com.main.tests;

import com.main.pages.PhotoPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPhoto extends BaseTest {
    private final String PHOTO_DIR = "/home/coincedence/Photos/4.bmp";
    @Test
    public void testPhotos() {
        final String setAlbumName = "New album!!!";
        UserPage userPage = new UserPage();
        userPage.goToPhotos();
        PhotoPage photoPage = new PhotoPage();
        String albumName = photoPage
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
