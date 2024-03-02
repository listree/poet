package com.walm;

import java.util.*;

/**
 * 841. Keys and Rooms Solved Medium
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms.
 * However, you cannot enter a locked room without having its key.
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks,
 * and you can take all of them with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 * Runtime Beats 52.60% vs Memory Beats 72.91%
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        HashSet visited = new HashSet();
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(0);
        while( !queue.isEmpty() ) {
            Integer room = queue.poll();
            if(!visited.contains(room)) {
                visited.add(room);
                List<Integer> list = rooms.get(room);
                for( Integer key: list ) {
                    if( !visited.contains(key) ) {
                        queue.add(key);
                    }
                }
            }
        }

        return visited.size() == rooms.size();
    }

}
