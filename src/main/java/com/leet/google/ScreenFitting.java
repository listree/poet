package com.leet.google;

/**
 * https://leetcode.com/problems/sentence-screen-fitting/
 * Given a rows x cols screen and a sentence represented as a list of strings,
 * return the number of times the given sentence can be fitted on the screen.
 * The order of words in the sentence must remain unchanged, and a word cannot be split into two lines.
 * A single space must separate two consecutive words in a line.
 */
public class ScreenFitting {


    public final static void main(String[] args) {
        String[] sentence = {"i", "had", "apple", "pie"};
        //        Explanation:
        //        i-had
        //        apple
        //        pie-i
        //        had--
        //        The character '-' signifies an empty space on the screen.
        ScreenFitting leeter = new ScreenFitting();
        // Output: 1
        System.out.println(leeter.wordsTyping(sentence, 4, 5));

    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        return 0;
    }

}
