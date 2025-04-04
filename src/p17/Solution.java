package p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        backtrack(digits, result, digitToChar, new StringBuilder(), 0);

        return result;
    }

    public void backtrack(
            String digits,
            List<String> result,
            Map<Character, String> digitToChar,
            StringBuilder current,
            Integer index
    ) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = digitToChar.get(digits.charAt(index));
        for (char c: letters.toCharArray()) {
            current.append(c);
            backtrack(digits, result, digitToChar, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
