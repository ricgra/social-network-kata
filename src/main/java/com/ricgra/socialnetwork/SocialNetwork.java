package com.ricgra.socialnetwork;

import com.ricgra.socialnetwork.model.Post;
import com.ricgra.socialnetwork.model.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SocialNetwork {

    private List<User> userList;

    public SocialNetwork() {
        userList = new ArrayList<>();
    }

    /**
     * Create a new post
     * @param username
     * @param postMessage
     * @return
     */
    public boolean createPost(String username, String postMessage) {
        Optional<User> optionalUser = findUser(userList, username);

        User user;
        if(!optionalUser.isPresent()) {
            user = new User();
            userList.add(user);
        } else {
            user = optionalUser.get();
        }

        user.setUsername(username);

        List<Post> posts = user.getPosts() == null ? new ArrayList<>() : user.getPosts();
        Post post = new Post();
        post.setUser(username);
        post.setMessage(postMessage);
        post.setInsertTime(Instant.now().toEpochMilli());
        posts.add(post);

        user.setPosts(posts);

        return true;
    }

    public String getPostsAndPrint(String username) {
        List<Post> posts = getPosts(username);

        return print(posts, false);
    }

    /**
     * Read all user posts
     * @param username
     * @return
     */
    public List<Post> getPosts(String username) {
        List<Post> userPosts = findUser(userList, username)
                .map(user -> user.getPosts())
                .orElseGet(ArrayList::new);

        return userPosts;
    }

    /**
     * Follow a user
     * @param username
     * @param usernameToFollow
     * @return
     */
    public boolean follow(String username, String usernameToFollow) {
        User user = findUser(userList, username)
                .get();

        List<String> follows = user.getFollowedUsernames();
        if(user.getFollowedUsernames() == null) {
            follows = new ArrayList<>();
        }

        follows.add(usernameToFollow);

        user.setFollowedUsernames(follows);

        return true;
    }

    public String getWallPostsAndPrint(String username) {
        List<Post> posts = getWallPosts(username);

        return print(posts, true);
    }

    /**
     * Get all wall posts of a user
     * @param username
     * @return
     */
    public List<Post> getWallPosts(String username) {
        List<Post> wallPosts = new ArrayList<>();

        User currentUser = findUser(userList, username)
                .orElseGet(User::new);

        wallPosts.addAll(currentUser.getPosts());

        if(currentUser.getFollowedUsernames() == null) {
            return wallPosts;
        }

        List<User> followdUsers = userList.stream()
                .filter(listUser -> currentUser.getFollowedUsernames().contains(listUser.getUsername()))
                .collect(Collectors.toList());
        followdUsers.forEach(followedUser -> wallPosts.addAll(followedUser.getPosts()));

        return wallPosts;
    }

    public String print(List<Post> posts, boolean printName) {
        StringBuilder output = new StringBuilder();
        if(posts == null || posts.isEmpty()) {
            return output.toString();
        }

        posts.forEach(post ->  {
            if(printName) {
                output.append(post.getUser());
                output.append(" - ");
            }
            output.append(post.getMessage());
            output.append("\n");
        });
        output.deleteCharAt(output.length() - 1);

        System.out.println(output.toString());

        return output.toString();
    }

    /**
     * Find user in list
     * @param userList
     * @param username
     * @return
     */
    private Optional<User> findUser(List<User> userList, String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

}
