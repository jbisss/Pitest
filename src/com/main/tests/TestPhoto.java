package com.main.tests;

import com.main.pages.LoginPage;
import com.main.pages.PhotoPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestPhoto extends BaseTest {
    /**
     * Проверка на корректное добавление альбома
     */
    @Test
    public void testPhotos(){
        final String setAlbumName = "New album!!!";
        String albumName = new LoginPage()
                .login()
                .goToPhotos()
                .addAlbum()
                .nameAlbum(setAlbumName)
                .createAlbum()
                .goToAlbumsList()
                .findAlbum(setAlbumName);
        assertEquals(setAlbumName, albumName);
    }
}
