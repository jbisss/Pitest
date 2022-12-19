package com.main.tests;

import com.main.pages.LoginPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestClass extends BaseTest {
    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage();
        assertEquals("technoPol10 technoPol10", loginPage.takeUserName());
    }
}
