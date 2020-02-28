package com.avodotiiets.misc;

import com.avodotiiets.LeetcodeLink;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 */
@LeetcodeLink("https://leetcode.com/problems/guess-number-higher-or-lower/")
public class GuessNumberLowerOrHigher extends GuessGame {

    public GuessNumberLowerOrHigher(int number) {
        super(number);
    }

    public int guessNumber(int n) {
        int l = 0;
        int h = n;

        while (l <= h) {
            int m = l + (h - l) / 2;
            int guessRes = guess(m);
            if (guessRes == 0) {
                return m;
            }
            if (guessRes == 1) {
                l = m + 1;
            }
            if (guessRes == -1) {
                h = m - 1;
            }
        }
        return -1;
    }
}

class GuessGame {

    private final int n;

    public GuessGame(int number) {
        this.n = number;
    }

    int guess(int m) {
        if (n == m) {
            return 0;
        }
        if (n < m) {
            return 1;
        } else {
            return -1;
        }
    }
}
