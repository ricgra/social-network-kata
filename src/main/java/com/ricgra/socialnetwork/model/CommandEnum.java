package com.ricgra.socialnetwork.model;

import org.apache.commons.lang3.StringUtils;

public enum CommandEnum {

    POSTING(" -> "),
    READING(" "),
    FOLLOWS(" follows "),
    WALL(" wall");

    private String pattern;

    CommandEnum(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    /**
     * Get command type from a command in input
     * @param inputCommand
     * @return
     */
    public static CommandEnum getTypeFromInput(String inputCommand) {
        if(StringUtils.isEmpty(inputCommand)) {
            return null;
        }

        for(CommandEnum command : values()) {
            if(!" ".equals(command.getPattern()) && inputCommand.contains(command.getPattern())) {
                return command;
            }
        }

        return READING;
    }

}
