package com.main.tests;

import com.main.pages.PhotoPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

public class TestAlbum extends BaseTest {
    @DisplayName("Test checks correct album addition")
    @Test
    public void testPhotos(){
        final String setAlbumName = "New album!!!";
        int isAlbumExist = new UserPage()
                .goToPhotos()
                .addAlbum()
                .nameAlbum(setAlbumName)
                .createAlbum()
                .goToAlbumsList()
                .findAlbum(setAlbumName);
        assertTrue(isAlbumExist != -1);
    }
    @AfterEach
    public void closeTest(){
        final String setAlbumName = "New album!!!";
        PhotoPage photoPage = new PhotoPage();
        int albumIndex = photoPage
                .goToAlbumsList()
                .findAlbum(setAlbumName);
        if (albumIndex != -1) {
            photoPage
                    .getALBUM_SETTINGS(albumIndex).click();
            photoPage
                    .goToMenu()
                    .deleteAlbum()
                    .approveDeletion();
        }
    }
}
