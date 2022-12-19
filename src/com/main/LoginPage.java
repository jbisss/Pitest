package com.main;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    /**
     * Return current page after setting email
     *
     * @param email
     * @return current page
     */
    public LoginPage setEmail(String email){
        $(By.xpath("//*[@id='field_email']")).setValue(email);
        return this;
    }
    /**
     * Return current page after setting password
     *
     * @param pwd
     * @return current page
     */
    public LoginPage setPwd(String pwd){
        $(By.xpath("//*[@id=\"field_password\"]")).setValue(pwd);
        return this;
    }

    // action on page
    public LoginPage click(){
        $(By.xpath("//div[@class=\"login-form-actions\"]/input")).click();
        return this;
    }

    // takers
    public String takeUserName(){
        return $(By.xpath("//div[@class=\"tico ellip\"]")).text();
    }

}
