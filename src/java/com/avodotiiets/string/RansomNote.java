package com.avodotiiets.string;

import com.avodotiiets.LeetcodeLink;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
@LeetcodeLink("https://leetcode.com/problems/ransom-note/")
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomeCharCount = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            if (ransomeCharCount.containsKey(c)) {
                ransomeCharCount.put(c, ransomeCharCount.get(c) + 1);
            } else {
                ransomeCharCount.put(c, 1);
            }
        }

        for (char c : magazine.toCharArray()) {
            if (ransomeCharCount.containsKey(c)) {
                int charCount = ransomeCharCount.get(c);
                if (charCount == 1) {
                    ransomeCharCount.remove(c);
                } else {
                    ransomeCharCount.put(c, ransomeCharCount.get(c) - 1);
                }
            }
        }

        return ransomeCharCount.isEmpty();
    }
}
