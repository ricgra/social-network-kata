package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.CommandEnum;
import com.ricgra.socialnetwork.model.Post;

import java.util.List;

public class WallCommand extends AbstractCommand<List<Post>> {

    public WallCommand(String command, SocialNetwork socialNetwork) {
        super(CommandEnum.WALLS, command, socialNetwork);
    }

    @Override
    public List<Post> execute() {
        String username = inputData[0];

        return socialNetwork.getWallPosts(username);
    }

}
