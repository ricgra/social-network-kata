package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.Post;

import java.util.List;

public class WallCommand extends AbstractCommand<List<Post>> {

    public WallCommand(String command, SocialNetwork socialNetwork) {
        super(command, socialNetwork);
    }

    @Override
    public List<Post> execute() {
        return socialNetwork.getWallPosts(command);
    }

}
