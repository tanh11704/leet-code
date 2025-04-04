package p22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(n, new StringBuilder(), result, 0, 0);
        return result;
    }

    public void backtrack(int n, StringBuilder current, List<String> result, int index, int cur_open) {
        if (index == 2 * n) {
            if (cur_open == n) {
                result.add(current.toString());
            }
            return;
        }
        current.append("(");
        cur_open++;
        backtrack(n, current, result, index + 1, cur_open);
        cur_open--;
        current.deleteCharAt(current.length() - 1);

        int cur_close = index - cur_open;
        if (cur_close < cur_open) {
            current.append(")");
            backtrack(n, current, result, index + 1, cur_open);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
