package com.main.tests;

import com.main.pages.LoginPage;
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
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(LOGIN, PASSWORD);
        final String setAlbumName = "New album!!!";
        boolean isAlbumExist = new UserPage()
                .goToPhotos()
                .addAlbum()
                .nameAlbum(setAlbumName)
                .createAlbum()
                .goToAlbumsList()
                .findAlbum(setAlbumName);
        assertTrue(isAlbumExist);
    }

    /**
     * Удаление альбома
     */
    @AfterEach
    public void closeTest(){
        final String setAlbumName = "New album!!!";
        PhotoPage photoPage = new PhotoPage();
        boolean albumIndex = photoPage
                .goToAlbumsList()
                .findAlbum(setAlbumName);
        if (albumIndex) {
            photoPage
                    .goToAlbumSettings(setAlbumName)
                    .goToMenu()
                    .deleteAlbum()
                    .approveDeletion();
        }
    }
}
