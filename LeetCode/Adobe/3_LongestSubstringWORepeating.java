class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> lastIdx = new HashMap<Character, Integer>();
        
        int maxLen = 0;
        int curLen = 0;
        
        int start = 0;
        int end = 0;
        
        
        while (end < s.length()) {            

            char cur = s.charAt(end);
            int prevIdx = lastIdx.get(cur) != null ? lastIdx.get(cur).intValue() : -1;
            lastIdx.put(cur, end);
            end++;
            
            if(start <= prevIdx) {
                start = prevIdx + 1;
            }
            
            curLen = end - start;
            if(curLen > maxLen)
                maxLen = curLen;
        }
        
        
        return maxLen;
        
    }
}