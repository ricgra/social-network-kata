package com.ricgra.socialnetwork.unit;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.Post;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class SocialNetworkTest {

    private SocialNetwork socialNetwork;

    @BeforeTest
    public void init() {
        socialNetwork = new SocialNetwork();
    }

    @Test(priority = 1, description = "Should create users posts")
    public void shouldCreateUsersPosts() {
        Assert.assertTrue(socialNetwork.createPost("Alice", "I love the weather today"));
        Assert.assertTrue(socialNetwork.createPost("Bob", "Damn! We lost!"));
        Assert.assertTrue(socialNetwork.createPost("Bob", "Good game though."));
        Assert.assertTrue(socialNetwork.createPost("Charlie", "I'm in New York today! Anyone wants to have a coffee?"));
    }

    @Test(priority = 2, description = "Should read users posts")
    public void shouldReadUsersPosts() {
        List<Post> posts = socialNetwork.getPosts("Alice");
        Assert.assertEquals(posts.get(0).getMessage(), "I love the weather today");

        posts = socialNetwork.getPosts("Bob");
        Assert.assertEquals(posts.get(0).getMessage(), "Damn! We lost!");
        Assert.assertEquals(posts.get(1).getMessage(), "Good game though.");
    }

    @Test(priority = 3, description = "Should follow a user")
    public void shouldFollowAUser() {
        Assert.assertTrue(socialNetwork.follow("Charlie", "Alice"));
    }

    @Test(priority = 4, description = "Should get wall's posts")
    public void shouldGetWallPosts() {
        Assert.assertEquals(socialNetwork.getWallPosts("Charlie").size(), 2);
    }

    @Test(priority = 5, description = "Should print a user's post")
    public void shouldPrintPosts() {
        String posts = socialNetwork.getPostsAndPrint("Alice");
        Assert.assertEquals(posts, "I love the weather today");
    }

    @Test(priority = 6, description = "Should get and print posts of a user's wall")
    public void shouldGetWallPostsAndPrint() {
        String posts = socialNetwork.getWallPostsAndPrint("Charlie");

        String[] postsRows = posts.split("\n");
        Assert.assertEquals(postsRows[0], "Charlie - I'm in New York today! Anyone wants to have a coffee?");
        Assert.assertEquals(postsRows[1], "Alice - I love the weather today");
    }

    @Test(priority = 7, description = "Should get only user's posts from wall")
    public void shouldGetOnlyUserPostsFromWall() {
        Assert.assertEquals(socialNetwork.getWallPosts("Bob").size(), 2);
    }

}
