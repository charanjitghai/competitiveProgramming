class Solution {
    
    private int numSubArraysWithBound(int[] A, int bound){
        
        int total = 0;
        int cur = 0;
        
        for(int i = 0; i<A.length; i++){
            if(A[i] <= bound){
                cur++;
            }
            else{
                total += cur*(cur+1)/2;
                cur = 0;
            }
        }
        
        if(cur != 0)
            total += cur*(cur+1)/2;
        
        return total;
    }
    
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        
        int numSubarraysWithMaxR = numSubArraysWithBound(A, R);
        int numSubarraysWithMaxL_1 = numSubArraysWithBound(A, L-1);
        
        return numSubarraysWithMaxR - numSubarraysWithMaxL_1;
        
    }
}