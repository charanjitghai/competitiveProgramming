class Solution {
    public int climbStairs(int n) {
        
        if(n==1 || n==2)
            return n;
        
        int[] climbStairsCache = new int[n+1];
        
        climbStairsCache[1] = 1;
        climbStairsCache[2] = 2;
        
        for(int steps = 3; steps<=n ; steps++){
            climbStairsCache[steps] = climbStairsCache[steps-1] + climbStairsCache[steps-2];
        }
        
        return climbStairsCache[n];
    }
}