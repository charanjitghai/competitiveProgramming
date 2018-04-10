class Solution {
    
    private int[] getLongestOddLengthPalindromeEnds(String s, int center) {
        
        int start = center;
        int end = center;
        
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        start++;
        end--;
        
        return new int[]{start, end};
    }
    
    
    private int[] getLongestEvenLengthPalindromeEnds(String s, int leftCenter, int rightCenter) {
        
        int start = leftCenter;
        int end = rightCenter;
        
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        start++;
        end--;
        
        return new int[]{start, end};
    }
    
    public String longestPalindrome(String s) {
        
        int maxLenStart = 0;
        int maxLenEnd = 0;
        int maxLen = 1;
        
        for(int center = 0; center < s.length(); center++){
            int[] ends = getLongestOddLengthPalindromeEnds(s, center);
            int start = ends[0];
            int end = ends[1];
            
            if(maxLen < (end - start + 1)) {
                maxLen = end - start + 1;
                maxLenStart = start;
                maxLenEnd = end;
            }
            
            ends = getLongestEvenLengthPalindromeEnds(s, center, center+1);
            start = ends[0];
            end = ends[1];
            if(maxLen < (end - start + 1)) {
                maxLen = end - start + 1;
                maxLenStart = start;
                maxLenEnd = end;
            }
        }
        
        return s.substring(maxLenStart, maxLenEnd+1);
    }
}