package com.leet.google;

import java.util.*;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 * Design a logger system that receives a stream of messages along with their timestamps. (Easy)
 * Each unique message should only be printed at most every 10 seconds
 * (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 * Implement the Logger class:
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * [null, true, true, false, false, false, true]
 * Runtime: 66 ms, faster than 50.10% of Java online submissions for Logger Rate Limiter.
 * Memory: 62.6 MB, less than 75.50% of Java online submissions for Logger Rate Limiter.
 */
public class RateLimiter {

    HashMap<String, Integer> map;
    public RateLimiter() {
        map = new HashMap<String, Integer>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer x = map.get(message);

        if( x != null && x.intValue() > timestamp )
            return false;

        map.put(message, timestamp + 10);
        return true;
    }

}
