package com.meta;

/**
 * https://leetcode.com/problems/edit-distance/
 * 72. Edit Distance Medium TODO
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class EditDistance {

    public final static void main(String[] args) {

        // Time Limit Exceeded
        String word1 = "pneumonoultramicroscopicsilicovolcanoconiosis";
        String word2 = "stereomicroscopically";
//        String word1 = "dinitrophenylhydrazine";
//        String word2 = "benzalphenylhydrazone";
//        String word1 = "horse";
//        String word2 = "ros";
        EditDistance ed = new EditDistance();
        long startTime = System.currentTimeMillis();
        int result = ed.minDistance(word1, word2);
        long endTime = System.currentTimeMillis();
        System.out.println(result + " - " + (endTime-startTime));
    }

    public int minDistance(String word1, String word2) {
        if( word2.isEmpty() )
            return word1.length();

        if( word1.isEmpty() )
            return word2.length();

        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return minDistanceDP(word1, word2, dp);

    }

    public int minDistanceDP(String word1, String word2, Integer[][] dp) {

        if( word2.isEmpty() ) {
            return word1.length();
        }

        if( word1.isEmpty() )
            return word2.length();

        if( dp[word1.length()-1][word2.length()-1] != null )
            return dp[word1.length()-1][word2.length()-1];

        // word1 & word2 both non empty
        if( word1.charAt(word1.length()-1) == word2.charAt(word2.length()-1) )
            return minDistanceDP(word1.substring(0,word1.length()-1), word2.substring(0,word2.length()-1), dp);

        int minRest =  min3(
                minDistanceDP(word1, word2.substring(0,word2.length()-1), dp),
                minDistanceDP(word1.substring(0,word1.length()-1), word2, dp),
                minDistanceDP(word1.substring(0,word1.length()-1), word2.substring(0,word2.length()-1), dp)
        );

        dp[word1.length()-1][word2.length()-1] = minRest + 1;
        return minRest + 1;
    }

    private int min3(int x, int y, int z) {
        return Math.min(Math.min(x,y),z);
    }

}
