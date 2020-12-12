package com.ricgra.socialnetwork;

import com.ricgra.socialnetwork.util.ConsoleUtils;

public class SocialNetworkApp {

    public static void main(String[] args) {
        SocialNetworkExecutor socialNetwork = new SocialNetworkExecutor();

        boolean breakCondition;
        do {
            ConsoleUtils.printPrompt();
            String input = ConsoleUtils.readInput();
            String executionOutput = socialNetwork.runCommand(input);

            breakCondition = executionOutput == null;
        } while (!breakCondition);
    }

}