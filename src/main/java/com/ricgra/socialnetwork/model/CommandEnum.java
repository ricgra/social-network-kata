package com.ricgra.socialnetwork.model;

import org.apache.commons.lang3.StringUtils;

public enum CommandEnum {

    POSTING(" -> "),
    READING(" "),
    FOLLOWS(" follows "),
    WALLS(" wall");

    private String pattern;

    CommandEnum(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public static CommandEnum getTypeFromInput(String input) {
        if(StringUtils.isEmpty(input)) {
            return null;
        }

        for(CommandEnum command : values()) {
            if(!" ".equals(command.getPattern()) && input.contains(command.getPattern())) {
                return command;
            }
        }

        return READING;
    }

}
