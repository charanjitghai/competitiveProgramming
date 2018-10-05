/**
** author: charanjitghai
** question: https://leetcode.com/explore/interview/card/google/59/array-and-strings/339/
*/


class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length -1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
        }

        if(carry == 0)
            return digits;
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
