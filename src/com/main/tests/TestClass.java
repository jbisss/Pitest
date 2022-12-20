package com.main.tests;

import com.main.pages.LoginPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestClass extends BaseTest {
    @DisplayName("Test checks correct logging in")
    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage();
        String realUsername = loginPage
                .takeUserName();
        assertEquals("technoPol10 technoPol10", realUsername);
    }
}
