package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.CommandEnum;
import com.ricgra.socialnetwork.model.Post;

import java.util.List;

public class WallCommand extends AbstractCommand<List<Post>> {

    public WallCommand(String command, SocialNetwork socialNetwork) {
        super(CommandEnum.WALL, command, socialNetwork);
    }

    @Override
    public List<Post> execute() {
        String username = getUsernameFromCommand();

        return socialNetwork.getWallPosts(username);
    }

}
