class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length() ; i++) {
            char curChar = s.charAt(i);
            if( ! freqMap.containsKey(curChar)) {
                freqMap.put(curChar, 1);
            }
            else {
                freqMap.put(curChar, freqMap.get(curChar) + 1);
            }
        }
        
        for(int i = 0; i<t.length() ; i++) {
            char curChar = t.charAt(i);
            if(freqMap.containsKey(curChar)) {
                int f = freqMap.get(curChar);
                if(f == 0)
                    return false;
                freqMap.put(curChar, f-1);
            }
            else
                return false;
        }
        
        return true;
    }
}