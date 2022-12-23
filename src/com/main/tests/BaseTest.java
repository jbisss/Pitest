package com.main.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    protected static final String LOGIN = "technoPol10";
    protected static final String PASSWORD = "technoPolis2022";

    /**
     * Открытие страницы Одноклассников
     */
    @BeforeEach
    public void openPage(){
        open("https://ok.ru");
    }

    /**
     * Очистка cookies
     */
    @AfterEach
    public void closePage(){
        clearBrowserCookies();
    }
}
