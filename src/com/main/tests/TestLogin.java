package com.main.tests;

import com.main.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestLogin extends BaseTest {
    @DisplayName("Test checks correct logging in")
    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(LOGIN, PASSWORD);
        assertEquals("technoPol10 technoPol10", loginPage.takeUserName());
    }
}
