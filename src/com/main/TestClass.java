package com.main;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestClass extends BaseTest {
    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage();
        String realUsername = loginPage
                .setEmail("technoPol10")
                .setPwd("technoPolis2022")
                .click()
                .takeUserName();
        assertEquals("technoPol10 technoPol10", realUsername);
    }
}
