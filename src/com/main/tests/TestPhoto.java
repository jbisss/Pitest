package com.main.tests;

import com.main.pages.PhotoPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestPhoto extends BaseTest {
    @Test
    public void testPhotos(){
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
    @Test
    public void testPhotoUpload()
    {
        UserPage userPage = new UserPage();
        userPage.goToPhotos();
    }
}
