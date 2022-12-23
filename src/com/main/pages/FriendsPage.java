package com.main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class FriendsPage {
    private final SelenideElement SEARCH_FIELD = $(By.xpath("//div[contains(@class,\"search_cnt\")]//input"));
    private final String ADD_FRIEND_BUTTON_XPATH_START;
    private final SelenideElement LAST_ELEMENT_TO_LOAD = $(By.xpath("//div[@id=\"rightColumn\"]"));
    private final SelenideElement SHOW_MORE_BUTTON = $(By.xpath("//span[contains(@class,'SecLabelText')]"));
    private final SelenideElement GO_TO_OUTGOING_REQS_BUTTON = $(By.xpath("//a[contains(@data-l,'OutgoingFriendRequest')]"));
    private final String FRIEND_IN_REQ_LIST_XPATH_START;
    // инициализируем константы в инициализаторы, потому что при создании - ругается)
    {
        ADD_FRIEND_BUTTON_XPATH_START = "//*[contains(text(),\"";
        FRIEND_IN_REQ_LIST_XPATH_START = "//*[contains(text(),\"";
    }

    /**
     * Поиск друга в одноклассниках
     * @param friendName имя друга
     * @return текущую страницу
     */
    public FriendsPage findFriend(String friendName)
    {
        LAST_ELEMENT_TO_LOAD.shouldBe(Condition.visible.because("Не удалось загрузить страницу"));
        SEARCH_FIELD.shouldBe(Condition.interactable.because("Нет строки поиска"))
                .setValue(friendName)
                .pressEnter();
        return this;
    }
    /**
     * Отправляет запрос на добавление в друзья
     * @param friendName имя друга
     * @return текущую страницу
     */
    public FriendsPage addFriend(String friendName)
    {
        var addFriendButton = $(By.xpath(ADD_FRIEND_BUTTON_XPATH_START + friendName
                + "\")]/../../../..//span[contains(text(), \"Добавить\")]"));
        addFriendButton.should(Condition.exist.because("Друг не найден"))
                .shouldBe(Condition.visible.because("Нет кнопки \"Добавить в друзья\""))
                .click();
        return this;
    }
    /**
     * Переходит к списку исходящих запросов
     *
     * @return текущую страницу
     */
    public FriendsPage goToFriendRequests()
    {
        SHOW_MORE_BUTTON.shouldBe(Condition.visible.because("Нет кнопки \"Ещё\"")).click();
        GO_TO_OUTGOING_REQS_BUTTON.shouldBe(Condition.visible.because("Нет кнопки \"Исходящие заявки\"")).click();
        return this;
    }
    /**
     * Проверяет существование запроса на добавление друга с именем friendName
     * @param friendName имя друга
     * @return true, если запрос найден
     */
    public boolean checkRequestExistence(String friendName)
    {
        var reqXpath = FRIEND_IN_REQ_LIST_XPATH_START + friendName + "\")]";
        return $(By.xpath(reqXpath)).exists();
    }
    /**
     * Удаляет запрос на добавление друга friendName
     * @param friendName имя друга
     */
    public void removeFriendRequest(String friendName)
    {
        var removeButton = $(By.xpath(FRIEND_IN_REQ_LIST_XPATH_START + friendName + "\")]/../../..//span"));
        removeButton.click();
    }
}
