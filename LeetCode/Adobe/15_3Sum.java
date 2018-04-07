class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int first = 0; first <= nums.length -3; first++){
            
            if(first > 0 && nums[first-1] == nums[first])
                continue;
            
            int second = first + 1;
            int third = nums.length -1;
            
            while(second < third){
                
                int curSum = nums[first] + nums[second] + nums[third];
                
                if(curSum < 0)
                    second++;
                else if(curSum > 0)
                    third--;
                else{
                    
                    List<Integer> currentCandidate = new ArrayList<Integer>();
                    
                    currentCandidate.add(nums[first]);
                    currentCandidate.add(nums[second]);
                    currentCandidate.add(nums[third]);
                    
                    List<Integer> lastCandidate = ans.size() != 0 ? ans.get(ans.size() -1) : null;
                    if(lastCandidate == null || ! lastCandidate.get(1).equals(currentCandidate.get(1))
                        || ! lastCandidate.get(2).equals(currentCandidate.get(2))) {
                        
                        ans.add(currentCandidate);
                    
                    }
                    
                    // just second/just third could also be changed, but can not lead to sum 0.
                    second++;
                    third--;
                }
            }
            
        }
        
        return ans;
    }
}