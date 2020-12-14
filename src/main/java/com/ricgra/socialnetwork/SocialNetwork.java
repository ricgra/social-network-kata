package com.ricgra.socialnetwork;

import com.ricgra.socialnetwork.model.Post;
import com.ricgra.socialnetwork.model.User;

import java.util.ArrayList;
import java.util.Collections;
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
        Post post = new Post(username, postMessage);
        posts.add(post);

        user.setPosts(posts);

        return true;
    }

    /**
     * Read all user posts
     * @param username
     * @return user's post or null if not exists the user
     */
    public List<Post> getPosts(String username) {
        Optional<List<Post>> optionalUserPosts = findUser(userList, username)
                .map(user -> user.getPosts());

        if(!optionalUserPosts.isPresent()) {
            return null;
        }

        List<Post> userPosts = optionalUserPosts.get();

        Collections.reverse(userPosts);

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

    /**
     * Get all wall posts of a user
     * @param username
     * @return the user's wall or null if the user not exists
     */
    public List<Post> getWallPosts(String username) {
        List<Post> wallPosts = new ArrayList<>();

        Optional<User> optionalUser = findUser(userList, username);
        if(!optionalUser.isPresent()) {
            return null;
        }

        User currentUser = optionalUser.get();

        wallPosts.addAll(currentUser.getPosts());

        if(currentUser.getFollowedUsernames() == null) {
            return wallPosts;
        }

        List<User> followdUsers = userList.stream()
                .filter(listUser -> currentUser.getFollowedUsernames().contains(listUser.getUsername()))
                .collect(Collectors.toList());

        followdUsers.forEach(followedUser -> wallPosts.addAll(followedUser.getPosts()));

        Collections.sort(wallPosts);

        return wallPosts;
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
