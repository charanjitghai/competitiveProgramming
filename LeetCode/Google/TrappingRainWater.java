/**
** author: charanjitghai
** question: https://leetcode.com/explore/interview/card/google/59/array-and-strings/341/
*/


class Solution {
    public int trap(int[] height) {

        if(height.length == 0)
            return 0;

        int[] lmx = new int[height.length];
        lmx[0] = 0;
        int mx = height[0];
        for(int i = 1; i<height.length; i++) {
            lmx[i] = mx;
            mx = Math.max(mx, height[i]);
        }

        int[] rmx = new int[height.length];
        rmx[height.length -1] = 0;
        mx = height[height.length -1];
        for(int i = height.length -2; i>=0 ; i--) {
            rmx[i] = mx;
            mx = Math.max(mx, height[i]);
        }

        int ans = 0;
        for(int i = 1; i<height.length-1; i++) {
            int lm = lmx[i];
            int rm = rmx[i];
            int min = Math.min(lm, rm);
            if(min > height[i])
                ans += (min - height[i]);
        }

        return ans;
    }
}
