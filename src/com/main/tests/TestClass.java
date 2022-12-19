package com.main.tests;

import com.main.pages.LoginPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestClass extends BaseTest {
    @Test
    public void testLogin(){
        final String LOGIN = "technoPol10";
        final String PASSWORD = "technoPolis2022";
        LoginPage loginPage = new LoginPage();
        String realUsername = loginPage
                .setEmail(LOGIN)
                .setPwd(PASSWORD)
                .click()
                .takeUserName();
        assertEquals("technoPol10 technoPol10", realUsername);
    }
}
