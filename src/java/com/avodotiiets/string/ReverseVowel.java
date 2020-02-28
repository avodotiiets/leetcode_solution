package com.avodotiiets.string;

import com.avodotiiets.LeetcodeLink;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
@LeetcodeLink("https://leetcode.com/problems/reverse-vowels-of-a-string/")
public class ReverseVowel {

    private final Set<Character> vowels = new HashSet<>(5);

    public ReverseVowel() {
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('i');
        vowels.add('u');
    }

    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int l = 0;
        int h = res.length - 1;

        while (l < h) {
            if (isVowel(res[l]) && isVowel(res[h])) {
                char t = res[l];
                res[l] = res[h];
                res[h] = t;
                l++;
                h--;
                continue;
            }
            if (!isVowel(res[l]) && !isVowel(res[h])) {
                l++;
                h--;
                continue;
            }
            if (isVowel(res[l])) {
                h--;
            } else {
                l++;
            }
        }

        return new String(res);
    }

    private boolean isVowel(char c) {
        return vowels.contains(Character.toLowerCase(c));
    }
}
