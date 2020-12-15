package com.ricgra.socialnetwork.command;

import com.ricgra.socialnetwork.SocialNetwork;
import com.ricgra.socialnetwork.model.CommandEnum;

public abstract class AbstractCommand<T> implements Command<T> {

    protected CommandEnum commandEnum;
    protected String command;
    protected SocialNetwork socialNetwork;
    protected String[] inputData;

    public AbstractCommand(CommandEnum commandEnum, String command, SocialNetwork socialNetwork) {
        this.commandEnum = commandEnum;
        this.command = command;
        this.socialNetwork = socialNetwork;
        inputData = parseInputAsArray();
    }

    /**
     * Parse console input command
     * @return
     */
    protected String[] parseInputAsArray() {
        String pattern = commandEnum.getPattern();

        return command.split(pattern);
    }

    protected String getUsernameFromCommand() {
        return inputData[0];
    }

}
