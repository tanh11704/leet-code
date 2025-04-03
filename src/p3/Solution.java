package p3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> maps = new HashMap<>();

        while (right < s.length()) {
            if (maps.containsKey(s.charAt(right))) {
                left = Math.max(maps.get(s.charAt(right)) + 1, left);
                maps.remove(s.charAt(right));
            }
            maps.put(s.charAt(right), right);
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
