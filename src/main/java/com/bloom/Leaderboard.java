package com.bloom;

import java.util.*;

/**
 * 1244. Design A Leaderboard Solved Medium
 * https://leetcode.com/problems/design-a-leaderboard/description/
 * Design a Leaderboard class, which has 3 functions:
 * addScore(playerId, score): Update the leaderboard by adding score to the given player's score.
 * If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
 * top(K): Return the score sum of the top K players.
 * reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard).
 * It is guaranteed that the player was added to the leaderboard before calling this function.
 * Initially, the leaderboard is empty.
 */
class Leaderboard {

    public final static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard ();
        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(1));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
    }
    TreeSet<Player> set;
    HashMap<Integer, Player> map;

    public Leaderboard() {
        set = new TreeSet<Player>();
        map = new HashMap<Integer, Player>();
    }

    public void addScore(int playerId, int score) {
        if( map.containsKey(playerId) ) {
            Player p = map.get(playerId);
            set.remove(p);
            p.score += score;
            set.add(p);
        } else {
            Player p = new Player(playerId, score);
            map.put(playerId, p);
            set.add(p);
        }
    }

    public int top(int K) {
        int sum = 0;
        int count = 0;

        for( Player p : set.descendingSet() ) {
            count++;
            if( count > K )
                break;
            sum += p.score;
        }
        return sum;
    }

    public void reset(int playerId) {
        Player p = map.get(playerId);
        map.remove(p.playId);
        set.remove(p);
    }

    class Player implements Comparable<Player>{

        int playId;
        int score;

        Player(int id, int s) {
            playId = id;
            score = s;
        }

        public int compareTo(Player that) {
            if( this.score != that.score )
                return this.score - that.score;
            else
                return this.playId - that.playId;
        }

        public String toString() {
            return "Player:" + playId + "->" + score;
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
