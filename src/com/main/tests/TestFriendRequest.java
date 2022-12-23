package com.main.tests;

import com.main.pages.FriendsPage;
import com.main.pages.LoginPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFriendRequest extends BaseTest{
    private final String FRIEND_NAME="technoPol3";
    private boolean friendWasAdded;
    @AfterEach
    public void deleteFriendRequest()
    {
        if(friendWasAdded) {
            open("https://ok.ru");
            UserPage userPage = new UserPage();
            userPage.goToFriendList();
            FriendsPage friendsPage = new FriendsPage();
            friendsPage.goToFriendRequests()
                    .removeFriendRequest(FRIEND_NAME);
        }
    }
    @DisplayName("Тест создания запроса на добавление друга")
    @Test
    public void testFriendRequest()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(LOGIN, PASSWORD);
        friendWasAdded = false;
        UserPage userPage = new UserPage();
        userPage.goToFriendList();
        FriendsPage friendsPage = new FriendsPage();
        friendsPage
                .findFriend(FRIEND_NAME)
                .addFriend(FRIEND_NAME);
        friendWasAdded = friendsPage.checkRequestExistence(FRIEND_NAME);
        assertTrue(friendWasAdded, "Заявка не была создана");
    }
}
