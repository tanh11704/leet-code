package p12;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                int numOfDigit = num / 1000;
                roman.append("M".repeat(numOfDigit));
                num %= 1000;
            } else if (num >= 500) {
                if (num >= 900) {
                    roman.append("CM");
                    num -= 900;
                } else {
                    int numOfDigit = num / 500;
                    roman.append("D".repeat(numOfDigit));
                    num %= 500;
                }
            } else if (num >= 100) {
                if (num >= 400) {
                    roman.append("CD");
                    num -= 400;
                } else {
                    int numOfDigit = num / 100;
                    roman.append("C".repeat(numOfDigit));
                    num %= 100;
                }
            } else if (num >= 50) {
                if (num >= 90) {
                    roman.append("XC");
                    num -= 90;
                } else {
                    int numOfDigit = num / 50;
                    roman.append("L".repeat(numOfDigit));
                    num %= 50;
                }
            } else if (num >= 10) {
                if (num >= 40) {
                    roman.append("XL");
                    num -= 40;
                } else {
                    int numOfDigit = num / 10;
                    roman.append("X".repeat(numOfDigit));
                    num %= 10;
                }
            } else if (num >= 5) {
                if (num >= 9) {
                    roman.append("IX");
                    num -= 9;
                } else {
                    int numOfDigit = num / 5;
                    roman.append("V".repeat(numOfDigit));
                    num %= 5;
                }
            } else if (num >= 1) {
                if (num >= 4) {
                    roman.append("IV");
                    num -= 4;
                } else {
                    int numOfDigit = num;
                    roman.append("I".repeat(numOfDigit));
                    num %= 1;
                }
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(58));
    }
}
