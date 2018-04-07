class Solution {
    
    private int getRepeatingNum(int[] nums) {
        
        int repeatingNum = -1;
        
        for(int i = 0; i<nums.length; i++) {
            
            int ptr = nums[i];
            
            if(ptr < 0)
                ptr = -ptr;
            
            ptr--;
            
            
            if(nums[ptr] < 0){
                repeatingNum = ptr+1;
                break;
            }
            
            nums[ptr] = -nums[ptr];
        }
        
        return repeatingNum;
    }
    
    
    public int[] findErrorNums(int[] nums) {
        
        
        int sum = 0;
        for(int i = 0; i<nums.length; i++)
            sum += nums[i];
        
        int n = nums.length;
        
        int expectedSum = n*(n+1)/2;
        
        int repeatingNum = getRepeatingNum(nums);
        
        int dif = expectedSum - sum;
        
        
        int[] ans = {repeatingNum, repeatingNum+dif};
        
        return ans;
        
    }
}