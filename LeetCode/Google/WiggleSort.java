/**
* author: charanjitghai
* question: https://leetcode.com/problems/wiggle-sort/description/
*/

class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void wiggleSort(int[] nums) {
        for(int i = 0; i+1<nums.length; i++) {
            if(i %2 == 0) {
                if(nums[i+1] < nums[i]) {
                    swap(nums, i, i+1);
                }
            }
            else {
                if(nums[i+1] > nums[i]) {
                    swap(nums, i, i+1);
                }
            }
        }
    }
}
