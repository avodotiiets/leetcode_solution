package com.avodotiiets.array;

import com.avodotiiets.LeetcodeLink;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */
@LeetcodeLink("https://leetcode.com/problems/missing-number/")
public class MissingNumber {

    public int missingNumber(int[] nums) {
        boolean zeroPresent = false;
        int max = nums.length;
        int sum = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroPresent = true;
            }
            sum += num;
        }
        if (!zeroPresent) {
            return 0;
        }
        int expectedSum;
        if (max % 2 == 0) {
            expectedSum = max * (max / 2) + max / 2;
        } else {
            expectedSum = max * (max / 2 + 1);
        }
        return expectedSum - sum;
    }
}
