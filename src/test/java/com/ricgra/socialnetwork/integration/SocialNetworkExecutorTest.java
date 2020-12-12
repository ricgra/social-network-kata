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

    @Test(priority = 1)
    public void shouldNotRunNotExistingCommand() {
        Assert.assertNull(socialNetworkExecutor.runCommand(""));
    }

    @Test(priority = 2)
    public void shouldPostMessagesWithoutAnyError() {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Alice -> I love the weather today"), "");
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob -> Damn! We lost!"), "");
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob -> Good game though."), "");
        Assert.assertEquals(socialNetworkExecutor.runCommand("Charlie -> I'm in New York today! Anyone wants to have a coffee?"), "");
    }

    @Test(priority = 3)
    public void shouldGetMessagesWithoutAnyError() {
        Assert.assertEquals(socialNetworkExecutor.runCommand("Alice").split("\n").length, 1);
        Assert.assertEquals(socialNetworkExecutor.runCommand("Bob").split("\n").length, 2);
    }

    @Test(priority = 4)
    public void shouldFollowWithoutAnyError() {
        socialNetworkExecutor.runCommand("Charlie follows Bob");
    }

    @Test(priority = 5)
    public void shouldPrintWallWithoutAnyError() {
        socialNetworkExecutor.runCommand("Charlie walls");
    }

}
