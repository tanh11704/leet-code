package p40;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int candidate: candidates) {
            if (frequency.containsKey(candidate)) {
                frequency.put(candidate, frequency.get(candidate) + 1);
            } else {
                frequency.put(candidate, 1);
            }
        }
        List<Integer> uniqueCandidates = new ArrayList<>(frequency.keySet());
        List<Integer> candidate = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(uniqueCandidates, target, frequency, candidate, answer, 0, 0);
        return answer;
    }

    public void backtrack(
            List<Integer> uniqueCandidates,
            int target,
            Map<Integer, Integer> frequency,
            List<Integer> candidate,
            List<List<Integer>> answer,
            int current_sum,
            int index
    ) {
        if (current_sum == target) {
            answer.add(new ArrayList<>(candidate));
            return;
        }
        if (current_sum > target) {
            return;
        }
        for (int i = index; i < uniqueCandidates.size(); i++) {
            int num = uniqueCandidates.get(i);
            int maxCount = frequency.get(num);

            for (int j = 0; j < maxCount; j++) {
                candidate.add(num);
                current_sum += num;
                backtrack(uniqueCandidates, target, frequency, candidate, answer, current_sum, i + 1);
            }

            for (int j = 0; j < maxCount; j++) {
                candidate.removeLast();
                current_sum -= num;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(new Solution().combinationSum2(candidates, 8));
    }
}
