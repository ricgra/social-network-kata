package com.ricgra.socialnetwork;

import com.ricgra.socialnetwork.command.FollowCommand;
import com.ricgra.socialnetwork.command.PostCommand;
import com.ricgra.socialnetwork.command.ReadCommand;
import com.ricgra.socialnetwork.command.WallCommand;
import com.ricgra.socialnetwork.model.CommandEnum;
import com.ricgra.socialnetwork.model.Post;

import java.util.List;

public class SocialNetworkExecutor {

    private SocialNetwork socialNetwork;

    public SocialNetworkExecutor() {
        socialNetwork = new SocialNetwork();
    }

    public String runCommand(String inputCommand) {
        CommandEnum command = CommandEnum.getTypeFromInput(inputCommand);
        if(command == null) {
            return null;
        }

        switch(command) {
            case POSTING:
                boolean isPosted = new PostCommand(inputCommand, socialNetwork).execute();

                return isPosted ? "" : null;
            case READING:
                List<Post> posts = new ReadCommand(inputCommand, socialNetwork).execute();

                return socialNetwork.print(posts, false);
            case FOLLOWS:
                boolean isFollow = new FollowCommand(inputCommand, socialNetwork).execute();

                return isFollow ? "" : null;
            case WALLS:
                List<Post> wallPosts = new WallCommand(inputCommand, socialNetwork).execute();

                return socialNetwork.print(wallPosts, true);
            default:
                return null;
        }
    }

}
