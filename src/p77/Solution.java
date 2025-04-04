package p77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(n, k, new ArrayList<>(), answer, 1);
        return answer;
    }

    public void backtrack(
            int n,
            int k,
            List<Integer> candidate,
            List<List<Integer>> answer,
            int start
    ) {
        if (candidate.size() == k) {
            answer.add(new ArrayList<>(candidate));
            return;
        }

        for (int i = start; i <= n; i++) {
            candidate.add(i);
            backtrack(n, k, candidate, answer, i + 1);
            candidate.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
