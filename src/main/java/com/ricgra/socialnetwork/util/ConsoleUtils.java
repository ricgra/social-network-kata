package com.ricgra.socialnetwork.util;

import java.util.Scanner;

public class ConsoleUtils {

    public static void printPrompt() {
        System.out.print("> ");
    }

    /**
     * Scan console input by line
     * @return
     */
    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
