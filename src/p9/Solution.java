package p9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xStr = String.valueOf(x);
        for (int i = 0; i < xStr.length() / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(xStr.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(4224));
    }
}
