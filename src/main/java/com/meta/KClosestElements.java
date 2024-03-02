package com.meta;
import java.util.*;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 * 658. Find K Closest Elements Medium Accepted
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class KClosestElements {

    public final static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        KClosestElements kce = new KClosestElements();
        List<Integer> list = kce.findClosestElements(arr, 4, 3);
        System.out.println(list);

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        LinkedList<Integer> list = new LinkedList<>();

        int[] range = findMiddle(arr, x, 0, arr.length-1);
        int i = range[0];
        int j = range[1];
        //System.out.println(i + "," + j);

        if( i == j ) {
            list.add(arr[i]);
            i--;
            j++;
            k--;
        }

        while( k > 0 ) {

            int a = Integer.MAX_VALUE;
            if(i > -1)
                a = Math.abs(arr[i] - x);

            int b = Integer.MAX_VALUE;
            if(j < arr.length)
                b = Math.abs(arr[j] - x);

            //System.out.println(a + ">" + b);
            if( a > b ) {
                list.addLast(arr[j]);
                j++;
            } else {
                list.addFirst(arr[i]);
                i--;
            }
            k--;
        }

        return list;
    }

    // find where x sits in arr
    int[] findMiddle(int[] arr, int x, int i, int j) {

        if( (j - i) <= 1) {
            return new int[]{i,j};
        }

        if (arr[i] > x) {
            return new int[]{i-1, i};
        }

        if (arr[j] < x) {
            return new int[]{j, j+1};
        }

        int mid = (i + j) / 2;
        if( arr[mid] > x)
            return findMiddle(arr, x, i, mid);
        else if( arr[mid] < x)
            return findMiddle(arr, x, mid, j);
        else
            return findMiddle(arr, x, mid, mid);

    }

}
