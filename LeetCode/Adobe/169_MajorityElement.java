/*
** Boyce Moore Voting Algorithm
*/

class Solution {
    public int majorityElement(int[] nums) {
        
        if(nums.length == 0)
            return -1;
        
        int majorityElem = nums[0];
        int majorityElemFreq = 1;
        
        for(int idx = 1; idx < nums.length ; idx++){
            if(nums[idx] != majorityElem){
                majorityElemFreq--;
                if(majorityElemFreq == 0){
                    majorityElemFreq = 1;
                    majorityElem = nums[idx];
                }
            }
            else
                majorityElemFreq++;
        }
        
        return majorityElem;
    }
}