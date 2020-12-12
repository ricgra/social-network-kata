package com.ricgra.socialnetwork;

import com.ricgra.socialnetwork.model.CommandEnum;
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
     * @param command command as string
     * @return
     */
    public boolean createPost(String command) {
        String pattern = CommandEnum.POSTING.getPattern();
        String[] userInputData = command.split(pattern);

        Optional<User> optionalUser = findUser(userList, userInputData[0]);

        User user;
        if(!optionalUser.isPresent()) {
            user = new User();
            userList.add(user);
        } else {
            user = optionalUser.get();
        }

        user.setUsername(userInputData[0]);

        List<Post> posts = user.getPosts() == null ? new ArrayList<>() : user.getPosts();
        Post post = new Post();
        post.setUser(userInputData[0]);
        post.setMessage(userInputData[1]);
        post.setInsertTime(Instant.now().toEpochMilli());
        posts.add(post);

        user.setPosts(posts);

        return true;
    }

    public String getPostsAndPrint(String command) {
        List<Post> posts = getPosts(command);

        return print(posts, false);
    }

    /**
     * Read all user posts
     * @param command command as string
     * @return
     */
    public List<Post> getPosts(String command) {
        String pattern = CommandEnum.READING.getPattern();
        String[] userInputData = command.split(pattern);

        List<Post> userPosts = findUser(userList, userInputData[0])
                .map(user -> user.getPosts())
                .orElseGet(ArrayList::new);

        return userPosts;
    }

    /**
     * Follow a user
     * @param command command as string
     * @return
     */
    public boolean follow(String command) {
        String pattern = CommandEnum.FOLLOWS.getPattern();
        String[] userInputData = command.split(pattern);

        User user = findUser(userList, userInputData[0])
                .get();

        List<String> follows = user.getFollowedUsernames();
        if(user.getFollowedUsernames() == null) {
            follows = new ArrayList<>();
        }

        follows.add(userInputData[1]);

        user.setFollowedUsernames(follows);

        return true;
    }

    public String getWallPostsAndPrint(String command) {
        List<Post> posts = getWallPosts(command);

        return print(posts, true);
    }

    /**
     * Get all wall posts of a user
     * @param command command as string
     * @return
     */
    public List<Post> getWallPosts(String command) {
        String pattern = CommandEnum.WALLS.getPattern();
        String[] userInputData = command.split(pattern);

        List<Post> wallPosts = new ArrayList<>();

        User currentUser = findUser(userList, userInputData[0])
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
