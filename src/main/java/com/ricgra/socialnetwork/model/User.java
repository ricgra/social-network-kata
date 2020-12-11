package com.ricgra.socialnetwork.model;

import java.util.List;

public class User {

    private String username;
    private List<Post> posts;
    private List<String> followedUsernames;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getFollowedUsernames() {
        return followedUsernames;
    }

    public void setFollowedUsernames(List<String> followedUsernames) {
        this.followedUsernames = followedUsernames;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
