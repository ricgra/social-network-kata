package com.ricgra.socialnetwork.integration;

import com.ricgra.socialnetwork.SocialNetworkExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class SocialNetworkExecutorTest {

    private SocialNetworkExecutor socialNetworkExecutor;

    @BeforeTest
    public void init() {
        socialNetworkExecutor = new SocialNetworkExecutor();
    }

    @Test(priority = 1, description = "Should return null for a invalid command in input")
    public void shouldNotRunNotExistingCommand() {
        Assert.assertNull(socialNetworkExecutor.runCommand(""));
    }

    @Test(priority = 2, description = "Should create user's posts")
    public void shouldPostMessagesWithoutAnyError() {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Alice -> I love the weather today"), "");
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob -> Damn! We lost!"), "");
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob -> Good game though."), "");
        Assert.assertEquals(socialNetworkExecutor.runCommand("Charlie -> I'm in New York today! Anyone wants to have a coffee?"), "");
    }

    @Test(priority = 3, description = "Should get and print user's posts")
    public void shouldGetPostsWithoutAnyError() {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Alice").split("\n").length, 1);
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob").split("\n").length, 2);
    }

    @Test(priority = 4, description = "Should print a user's post")
    public void shouldPrintAUserPost() {
        String posts = socialNetworkExecutor.runCommand("Alice");
        Assert.assertEquals(posts, "I love the weather today");
    }

    @Test(priority = 5, description = "Should follow a user")
    public void shouldFollowWithoutAnyError() {
        socialNetworkExecutor.runCommand("Charlie follows Bob");
    }

    @Test(priority = 6, description = "Should get a user's wall posts")
    public void shouldPrintWallWithoutAnyError() {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Charlie walls").split("\n").length, 3);
    }

    @Test(priority = 6, description = "Should get and print posts of a user's wall")
    public void shouldGetWallPostsAndPrint() {
        String posts = socialNetworkExecutor.runCommand("Charlie walls");

        String[] postsRows = posts.split("\n");
        Assert.assertEquals(postsRows[0], "Charlie - I'm in New York today! Anyone wants to have a coffee?");
        Assert.assertEquals(postsRows[1], "Bob - Damn! We lost!");
        Assert.assertEquals(postsRows[2], "Bob - Good game though.");
    }

}
