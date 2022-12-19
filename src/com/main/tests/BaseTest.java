package com.main.tests;

import com.main.pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeAll
    public static void openPage(){
        open("https://ok.ru");
        final String LOGIN = "technoPol10";
        final String PASSWORD = "technoPolis2022";
        LoginPage loginPage = new LoginPage();
        loginPage
                .setEmail(LOGIN)
                .setPwd(PASSWORD)
                .click();
    }
    @AfterAll
    public static void closePage(){
        clearBrowserCookies();
    }
}
