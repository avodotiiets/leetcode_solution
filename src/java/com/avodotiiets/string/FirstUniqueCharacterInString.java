package com.avodotiiets.string;

import com.avodotiiets.LeetcodeLink;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
@LeetcodeLink("https://leetcode.com/problems/first-unique-character-in-a-string/")
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (chars.containsKey(s.charAt(i))) {
                chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
            } else {
                chars.put(s.charAt(i), 1);
            }

        }

        for (int i = 0; i < s.length(); i++) {
            if (chars.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
