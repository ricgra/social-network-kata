package com.ricgra.socialnetwork.model;

import com.ricgra.socialnetwork.util.TimeUtils;

public class Post {

    private String user;
    private String message;
    private long insertTime;

    public Post() {}

    public Post(String user, String message) {
        this.user = user;
        this.message = message;
        insertTime = TimeUtils.getNowInMillis();
    }

    public Post(String user, String message, long insertTime) {
        this.user = user;
        this.message = message;
        this.insertTime = insertTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(long insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * Get the time formatted
     * ex. 15 seconds ago
     * @return
     */
    private String formatMessageTime() {
        return TimeUtils.getTimeAgo(insertTime);
    }

    /**
     * Get the time and message formatted
     * If printName is true:
     * ex. Name - Tweet message (15 seconds ago)
     * if not:
     * ex. Tweet message (15 seconds ago)
     * @param printName
     * @return
     */
    public String getFormattedMessage(boolean printName) {
        StringBuilder stringBuilder = new StringBuilder();
        if(printName) {
            stringBuilder.append(getUser());
            stringBuilder.append(" - ");
        }
        stringBuilder.append(getMessage());
        stringBuilder.append(" (");
        stringBuilder.append(formatMessageTime());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}
