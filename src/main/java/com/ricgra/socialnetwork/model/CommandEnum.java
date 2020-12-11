package com.ricgra.socialnetwork.model;

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

}
