package com.main.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeAll
    public static void openPage(){
        open("https://ok.ru");
    }
    @AfterAll
    public static void closePage(){
        clearBrowserCookies();
    }
}
