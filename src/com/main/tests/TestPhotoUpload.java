package com.main.tests;

import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

public class TestPhotoUpload extends BaseTest{
    @Test
    public void testPhotoUpload()
    {
        UserPage userPage = new UserPage();
        userPage.goToPhotos();
    }
}
