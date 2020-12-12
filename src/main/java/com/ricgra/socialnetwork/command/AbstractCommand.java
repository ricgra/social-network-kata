package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;

public abstract class AbstractCommand<T> implements Command<T> {

    protected String command;
    protected SocialNetwork socialNetwork;

    public AbstractCommand(String command, SocialNetwork socialNetwork) {
        this.command = command;
        this.socialNetwork = socialNetwork;
    }

}
