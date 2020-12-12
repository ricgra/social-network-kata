package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.CommandEnum;

public class PostCommand extends AbstractCommand<Boolean> {

    public PostCommand(String command, SocialNetwork socialNetwork) {
        super(CommandEnum.POSTING, command, socialNetwork);
    }

    @Override
    public Boolean execute() {
        String username = getUsernameFromCommand();
        String postMessage = inputData[1];

        return socialNetwork.createPost(username, postMessage);
    }

}
