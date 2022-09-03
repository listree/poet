package com.walm;

/** 6. Zigzag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 */
public class ZigzagConversion {

    public final static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();

        String result = zigzagConversion.convert("PAYPALISHIRING", 3);

        System.out.println(zigzagConversion.convert("AB", 1));

    }

    public String convert(String s, int numRows) {

        String[] rowStrings = new String[numRows];
        for(int i = 0 ; i < numRows; i++)
            rowStrings[i] = "";

        int rowNumber = 0;
        boolean down = true;

        for( char c: s.toCharArray() ) {
            rowStrings[rowNumber] += c;

            if( rowNumber == 0) {
                down = true;
            }

            if( rowNumber == numRows - 1)
                down = false;

            if( numRows != 1 ) {
                if( down )
                    rowNumber++;
                else
                    rowNumber--;
            }

        }

        String result = "";
        for(String str: rowStrings) {
            result += str;
        }
        return result;
    }

}
