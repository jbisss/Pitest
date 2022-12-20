package com.main.tests;

import com.main.pages.FriendsPage;
import com.main.pages.UserPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFriendRequest extends BaseTest{
    private final String FRIEND_NAME="technoPol3";
    @Test
    public void testFriendRequest()
    {
        UserPage userPage = new UserPage();
        userPage.goToFriendList();
        FriendsPage friendsPage = new FriendsPage();
        friendsPage
                .findFriend(FRIEND_NAME)
                .addFriend(FRIEND_NAME)
                .goToFriendRequests();
        assertEquals(friendsPage.checkRequestExistence(FRIEND_NAME), true, "Заявка не была создана");
        friendsPage.removeFriendRequest(FRIEND_NAME);
    }
}
