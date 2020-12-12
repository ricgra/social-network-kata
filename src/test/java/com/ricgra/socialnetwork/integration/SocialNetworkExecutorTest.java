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
    public void shouldPostMessagesWithoutAnyError() throws InterruptedException {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Alice -> I love the weather today"), "");
        // Needed to emulate the create post operation with differents timestamps
        Thread.sleep(1);
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob -> Damn! We lost!"), "");
        Thread.sleep(1);
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob -> Good game though."), "");
        Thread.sleep(1);
        Assert.assertEquals(socialNetworkExecutor.runCommand("Charlie -> I'm in New York today! Anyone wants to have a coffee?"), "");
    }

    @Test(priority = 3, description = "Should get and print user's posts")
    public void shouldGetPostsWithoutAnyError() {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Alice").split("\n").length, 1);
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob").split("\n").length, 2);
    }

    @Test(priority = 4, description = "Should print a user's post")
    public void shouldPrintAUserPost() {
        String post = socialNetworkExecutor.runCommand("Alice");
        Assert.assertTrue(post.startsWith("I love the weather today"));
    }

    @Test(priority = 6, description = "Should follow a user")
    public void shouldFollowFirstUserWithoutAnyError() {
        socialNetworkExecutor.runCommand("Charlie follows Alice");
    }

    @Test(priority = 7, description = "Should follow a user")
    public void shouldFollowSecondUserWithoutAnyError() {
        socialNetworkExecutor.runCommand("Charlie follows Bob");
    }

    @Test(priority = 8, description = "Should get a user's wall posts")
    public void shouldPrintWallWithoutAnyError() {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Charlie wall").split("\n").length, 4);
    }

    @Test(priority = 9, description = "Should get and print posts of a user's wall")
    public void shouldGetWallPostsAndPrint() {
        String posts = socialNetworkExecutor.runCommand("Charlie wall");

        String[] postsRows = posts.split("\n");
        Assert.assertTrue(postsRows[0].startsWith("Charlie - I'm in New York today! Anyone wants to have a coffee?"));
        Assert.assertTrue(postsRows[1].startsWith("Bob - Good game though."));
        Assert.assertTrue(postsRows[2].startsWith("Bob - Damn! We lost!"));
        Assert.assertTrue(postsRows[3].startsWith("Alice - I love the weather today"));
    }

}
