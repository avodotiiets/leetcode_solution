package com.avodotiiets;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a1 = new int[] {4,5,6,0,0,0};
        int[] a2 = new int[] {1,2,3};

        s.merge(a1, 3, a2, 3);
        System.out.println(Arrays.toString(a1));
    }
}

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;

        while(p1 < m && p2 < n) {
            int el1 = nums1[p1];
            int el2 = nums2[p2];

            if (el2 < el1) {
                // shift the rest right
                for (int i = p1; i < m; i++) {
                    swap(nums1, i, i+1);
                }
                // set el2 to p1
                nums1[p1] = el2;
                p2++;
                p1++;
            }
            p1++;
        }
        if (p2 < n) {
            while (p2 < n) {
                nums1[p1] = nums2[p2];
                p1++;
                p2++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
