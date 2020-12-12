package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.Post;

import java.util.List;

public class WallCommand implements Command<List<Post>> {

    private String command;
    private SocialNetwork socialNetwork;

    public WallCommand(String command, SocialNetwork socialNetwork) {
        this.command = command;
        this.socialNetwork = socialNetwork;
    }

    @Override
    public List<Post> execute() {
        return socialNetwork.getWallPosts(command);
    }

}
