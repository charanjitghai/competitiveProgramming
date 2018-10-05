/**
** author: charanjitghai
** question: https://leetcode.com/explore/interview/card/google/59/array-and-strings/459/
*/


class Solution {
    public int firstUniqChar(String s) {
        boolean[] repeated = new boolean[26];
        int[] firstIdx = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int li = s.charAt(i) - 'a';
            if(! repeated[li]) {
                if(firstIdx[li] != 0) {
                    repeated[li] = true;
                }
                else {
                    firstIdx[li] = i + 1;
                }
            }
        }

        int minIdx = s.length() + 1;
        for(int i = 0; i < 26; i++) {
            if((! repeated[i]) && firstIdx[i] > 0) {
                if(minIdx > firstIdx[i])
                    minIdx = firstIdx[i];
            }
        }

        if(minIdx == s.length() + 1)
            return -1;
        return minIdx -1;
    }
}
