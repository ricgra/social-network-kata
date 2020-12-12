package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.CommandEnum;

public class FollowCommand extends AbstractCommand<Boolean> {

    public FollowCommand(String command, SocialNetwork socialNetwork) {
        super(CommandEnum.FOLLOWS, command, socialNetwork);
    }

    @Override
    public Boolean execute() {
        String username = getUsernameFromCommand();
        String usernameToFollow = inputData[1];

        return socialNetwork.follow(username, usernameToFollow);
    }

}
