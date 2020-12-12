package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;

public class PostCommand implements Command<Boolean> {

    private String command;
    private SocialNetwork socialNetwork;

    public PostCommand(String command, SocialNetwork socialNetwork) {
        this.command = command;
        this.socialNetwork = socialNetwork;
    }

    @Override
    public Boolean execute() {
        return socialNetwork.createPost(command);
    }

}
