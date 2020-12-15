package com.ricgra.socialnetwork.util;

import com.ricgra.socialnetwork.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputUtils {

    /**
     * Writing all posts to console
     * @param posts
     * @param printName
     * @return
     */
    public static String print(List<Post> posts, boolean printName) {
        if(posts == null || posts.isEmpty()) {
            return "";
        }

        String output = buildConsoleMessage(posts, printName);

        System.out.println(output);

        return output;
    }

    /**
     * Build the post messages as string line by line
     * @param posts
     * @param printName
     * @return
     */
    public static String buildConsoleMessage(List<Post> posts, boolean printName) {
        return posts.stream()
                .map(post -> String.format(post.getFormattedMessage(printName), "\n"))
                .collect(Collectors.joining("\n"));
    }

}
