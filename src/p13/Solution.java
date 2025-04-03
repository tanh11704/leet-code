package p13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int number = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int numLeft = roman.get(s.charAt(i));
            int numRight = roman.get(s.charAt(i + 1));
            if (numLeft >= numRight) {
                number += numLeft;
            } else {
                number -= numLeft;
            }
        }
        return number + roman.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}
