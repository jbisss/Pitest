package com.main.tests;

import com.codeborne.selenide.SelenideElement;
import com.main.pages.LoginPage;
import com.main.pages.PhotoPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    protected static final String LOGIN = "technoPol10";
    protected static final String PASSWORD = "technoPolis2022";

    @BeforeEach
    public void openPage(){
        open("https://ok.ru");
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(LOGIN, PASSWORD);
    }
    @AfterEach
    public void closePage(){
        clearBrowserCookies();
    }
}
