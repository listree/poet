package com.leet.facebook;
import java.util.*;

/**
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 * 1570. Dot Product of Two Sparse Vectors (Medium)
 * Given two sparse vectors, compute their dot product.
 * Implement class SparseVector:
 * SparseVector(nums) Initializes the object with the vector nums
 * dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
 * A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute
 * the dot product between two SparseVector.
 * Follow up: What if only one of the vectors is sparse?
 * Runtime 9 ms Beats 66.47%
 * Memory 51.8 MB Beats 81.21%
 */
public class SparseVector {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] != 0 )
                map.put(i, nums[i]);
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0 ;
        for( int i : this.map.keySet() ) {
            if( vec.map.containsKey(i) ) {
                sum += this.map.get(i) * vec.map.get(i);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2)
