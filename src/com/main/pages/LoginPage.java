package com.main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement EMAIL_FIELD =  $(By.xpath("//*[@id='field_email']"));
    private final SelenideElement PASSWORD_FIELD = $(By.xpath("//*[@id=\"field_password\"]"));
    private final SelenideElement LOGIN_BUTTON = $(By.xpath("//div[@class=\"login-form-actions\"]/input"));
    private final SelenideElement NAME_FIELD =  $(By.xpath("//div[@class=\"tico ellip\"]"));

    /**
     * Возвращает текущую страницу после установки email
     *
     * @param email email для входа
     * @return текущую страницу
     */
    public LoginPage setEmail(String email){
        EMAIL_FIELD.shouldBe(Condition.visible.because("Нет поля логина!!!")).setValue(email);
        return this;
    }
    /**
     * Возвращает текущую страницу после установки пароля
     *
     * @param pwd пароль для входа
     * @return текущую страницу
     */
    public LoginPage setPwd(String pwd){
        PASSWORD_FIELD.shouldBe(Condition.visible.because("Нет поля пароля!!!")).setValue(pwd);
        return this;
    }

    /**
     * Кликает на кнопку логина
     *
     * @return текущую страницу
     */
    public LoginPage click(){
        LOGIN_BUTTON.shouldBe(Condition.visible.because("Нет кнопки!!!")).click();
        return this;
    }

    /**
     * Возвращает имя пользователя из соответствующего поля
     *
     * @return имя пользователя
     */
    public String takeUserName(){
        return NAME_FIELD.text();
    }
    /**
     * Логиниться в аккаунт
     */
    public void logIn(String login, String pwd){
        this.setEmail(login)
                .setPwd(pwd)
                .click();
    }
}
