package com.ricgra.socialnetwork.util;

import java.time.Instant;

public class TimeUtils {

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    /**
     * Get relative time as String
     * @param time start time in milliseconds
     * @return Return the relative time calculated from now
     */
    public static String getTimeAgo(long time) {
        if (time < 1000000000000L) {
            time *= 1000;
        }

        long now = getNowInMillis();
        if (time > now || time <= 0) {
            return null;
        }

        final long diff = now - time;
        if (diff < SECOND_MILLIS) {
            return "just now";
        } else if (diff < 2 * SECOND_MILLIS) {
            return "1 second ago";
        } else if (diff < 59 * SECOND_MILLIS) {
            return diff / SECOND_MILLIS + " seconds ago";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "1 minute ago";
        } else if (diff < 59 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "1 hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "1 day ago";
        } else {
            return diff / DAY_MILLIS + " days ago";
        }
    }

    public static long getNowInMillis() {
        return Instant.now().toEpochMilli();
    }

}
