package com.uber;

import java.util.*;

/**
 * 981. Time Based Key-Value Store (Medium)
 * https://leetcode.com/problems/time-based-key-value-store/description/
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps
 * and retrieve the key's value at a certain timestamp.
 * Implement the TimeMap class:
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values,
 * it returns "".
 */
class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        if ( !map.containsKey(key) )
            map.put(key, new TreeMap<Integer, String>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if( !map.containsKey(key) )
            return "";
        else {
            for( Integer x: map.get(key).descendingKeySet() ) {
                if( x <= timestamp )
                    return map.get(key).get(x);
            }
            return "";
        }

    }

}
