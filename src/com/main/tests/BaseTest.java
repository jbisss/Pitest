package com.main.tests;

import com.main.pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    private static final String LOGIN = "technoPol10";
    private static final String PASSWORD = "technoPolis2022";
    @BeforeAll
    public static void openPage(){
        open("https://ok.ru");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(LOGIN, PASSWORD);
    }
    @AfterAll
    public static void closePage(){
        clearBrowserCookies();
    }
}
