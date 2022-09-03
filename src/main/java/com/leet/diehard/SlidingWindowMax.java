package com.leet.diehard;

import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 239. Sliding Window Maximum (Hard)
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
 * by one position. Return the max sliding window.
 * Runtime: 85 ms, faster than 27.39% of Java online submissions for Sliding Window Maximum.
 * Memory: 145.1 MB, less than 67.51% of Java online submissions for Sliding Window Maximum.
 */
public class SlidingWindowMax {

    public static void main(String[] args) {

        SlidingWindowMax ha = new SlidingWindowMax();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        // Output: [3,3,5,5,6,7]
        int[] output = ha.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(output));

    }

    // PriorityQueue takes O(nln) Timeout
    // Monotonic Queue takes O(n) Passed
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return nums;

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> monoQueue = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            while (monoQueue.size() > 0 && nums[i] >= nums[monoQueue.getLast()])
                monoQueue.removeLast();

            monoQueue.addLast(i);

            if (i - k + 1 >= 0)
                ans[i - k + 1] = nums[monoQueue.getFirst()];

            if (i - k + 1 >= monoQueue.getFirst())
                monoQueue.removeFirst();
        }

        return ans;
    }

}
