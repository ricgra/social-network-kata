package com.ricgra.socialnetwork.util;

import com.ricgra.socialnetwork.model.Post;

import java.util.List;

public class ConsoleOutputUtils {

    public static String print(List<Post> posts, boolean printName) {
        StringBuilder output = new StringBuilder();
        if(posts == null || posts.isEmpty()) {
            return output.toString();
        }

        posts.forEach(post ->  {
            if(printName) {
                output.append(post.getUser());
                output.append(" - ");
            }
            output.append(post.getMessage());
            output.append("\n");
        });
        output.deleteCharAt(output.length() - 1);

        System.out.println(output.toString());

        return output.toString();
    }

}
