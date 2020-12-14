package com.ricgra.socialnetwork;

import com.ricgra.socialnetwork.command.*;
import com.ricgra.socialnetwork.model.CommandEnum;
import com.ricgra.socialnetwork.model.Post;
import com.ricgra.socialnetwork.util.ConsoleOutputUtils;

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
                boolean isPosted = executeCommand(new PostCommand(inputCommand, socialNetwork));

                return isPosted ? "" : null;
            case READING:
                return executeCommandAndPrint(new ReadCommand(inputCommand, socialNetwork), false);
            case FOLLOWS:
                boolean isFollow = executeCommand(new FollowCommand(inputCommand, socialNetwork));

                return isFollow ? "" : null;
            case WALL:
                return executeCommandAndPrint(new WallCommand(inputCommand, socialNetwork), true);
            default:
                return null;
        }
    }

    private <T> T executeCommand(Command command) {
        return (T) command.execute();
    }

    private String executeCommandAndPrint(Command command, boolean printName) {
        List<Post> posts = executeCommand(command);
        if(posts == null) {
            return null;
        }

        return ConsoleOutputUtils.print(posts, printName);
    }

}
