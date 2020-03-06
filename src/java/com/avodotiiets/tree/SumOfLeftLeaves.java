package com.avodotiiets.tree;

import com.avodotiiets.LeetcodeLink;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
@LeetcodeLink("https://leetcode.com/problems/sum-of-left-leaves/")
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if (root == null || isLeaf(root)) {
            return sum;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            TreeNode n = nodes.poll();
            if (n.left != null && isLeaf(n.left)) {
                sum += n.left.val;
            }
            if (n.left != null && !isLeaf(n.left)) {
                nodes.add(n.left);
            }
            if (n.right != null && !isLeaf(n.right)) {
                nodes.add(n.right);
            }
        }

        return sum;
    }

    private boolean isLeaf(TreeNode n) {
        return n.left == null && n.right == null;
    }
}
