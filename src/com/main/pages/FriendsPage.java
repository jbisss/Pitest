package com.main.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FriendsPage {
    private final SelenideElement SEARCH_FIELD = $(By.xpath("//div[contains(@class,\"search_cnt\")]//input"));
    private final String ADD_FRIEND_BUTTON_XPATH_START = "//*[contains(text(),'";
    private final SelenideElement SHOW_MORE_BUTTON = $(By.xpath("//span[contains(@class,'SecLabelText')]"));
    private final SelenideElement GO_TO_OUTGOING_REQS_BUTTON = $(By.xpath("//a[contains(@data-l,'OutgoingFriendRequest')]"));
    private final String FRIEND_IN_REQ_LIST_XPATH_START = "//*[contains(text(),\"";
    public FriendsPage findFriend(String friendName)
    {
        SEARCH_FIELD.shouldBe(Condition.visible.because("Нет строки поиска"))
                .setValue(friendName)
                .pressEnter();
        return this;
    }
    public FriendsPage addFriend(String friendName)
    {
        var addFriendButton = $(By.xpath(ADD_FRIEND_BUTTON_XPATH_START + friendName
                + "')]/../../../..//span[contains(text(), \"Добавить\")]"));
        addFriendButton.should(Condition.exist.because("Друг не найден"))
                .shouldBe(Condition.visible.because("Нет кнопки \"Добавить в друзья\""))
                .click();
        return this;
    }
    public FriendsPage goToFriendRequests()
    {
        SHOW_MORE_BUTTON.shouldBe(Condition.visible.because("Нет кнопки \"Ещё\"")).click();
        GO_TO_OUTGOING_REQS_BUTTON.shouldBe(Condition.visible.because("Нет кнопки \"Исходящие заявки\"")).click();
        return this;
    }
    public boolean checkRequestExistence(String friendName)
    {
        var reqXpath = FRIEND_IN_REQ_LIST_XPATH_START + friendName + "\")]";
        return $(By.xpath(reqXpath)).exists();
    }
    public void removeFriendRequest(String friendName)
    {
        var removeButton = $(By.xpath(FRIEND_IN_REQ_LIST_XPATH_START + friendName + "\")]/../../..//span"));
        removeButton.click();
    }
}
