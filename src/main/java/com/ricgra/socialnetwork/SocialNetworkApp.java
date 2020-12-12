package com.ricgra.socialnetwork;

import java.util.Scanner;

public class SocialNetworkApp {

    public static void main(String[] args) {
        SocialNetworkExecutor socialNetwork = new SocialNetworkExecutor();

        boolean breakCondition;
        do {
            String input = readInput();
            String executionOutput = socialNetwork.runCommand(input);
            breakCondition = executionOutput == null;
        } while (!breakCondition);
    }

    /**
     * Scan console input by line
     * @return
     */
    private static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}