/**
** author: charanjitghai
** question: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0)
            return 0;

        int start = 0;
        int end = 0;
        int[] freq = new int[256];
        int nd = 0;
        int maxL = 0;

        while(end < s.length()) {
            char c = s.charAt(end);
            if(nd < k || freq[c] > 0) {
                freq[c]++;
                if(freq[c] == 1)
                    nd++;
                end++;
            }
            else {
                maxL = Math.max(maxL, end - start);
                while(freq[s.charAt(start)] != 1) {
                    freq[s.charAt(start)]--;
                    start++;
                }
                freq[s.charAt(start)]--;
                start++;
                nd--;
            }
        }
        return Math.max(maxL, end - start);
    }
}
