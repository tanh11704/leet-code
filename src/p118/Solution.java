package p118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    newRow.add(1);
                } else {
                    newRow.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
            }
            triangle.add(newRow);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }
}
