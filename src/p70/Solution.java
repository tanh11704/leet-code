package p70;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> steps = new HashMap<>();
        steps.put(1, 1);
        steps.put(2, 2);
        for (int i = 3; i <= n; i++) {
            steps.put(i, steps.get(i-2) + steps.get(i-1));
        }

        return steps.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }
}
