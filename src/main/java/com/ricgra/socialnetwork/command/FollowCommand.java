package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;

public class FollowCommand extends AbstractCommand<Boolean> {

    public FollowCommand(String command, SocialNetwork socialNetwork) {
        super(command, socialNetwork);
    }

    @Override
    public Boolean execute() {
      return socialNetwork.follow(command);
    }

}
