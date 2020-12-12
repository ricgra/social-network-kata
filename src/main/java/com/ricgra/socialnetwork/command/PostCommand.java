package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;

public class PostCommand extends AbstractCommand<Boolean> {

    public PostCommand(String command, SocialNetwork socialNetwork) {
        super(command, socialNetwork);
    }

    @Override
    public Boolean execute() {
        return socialNetwork.createPost(command);
    }

}
