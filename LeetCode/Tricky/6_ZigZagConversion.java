class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() == 0)
            return s;
        
        String[] zigs = new String[numRows];
        Arrays.fill(zigs, "");
        
        int dir = 1;
        int zigsIdx = 0;
        int sIdx = 0;
        
        while(sIdx < s.length()) {
            
            zigs[zigsIdx] = zigs[zigsIdx] + s.charAt(sIdx);
            
            zigsIdx = zigsIdx + dir;
            if(zigsIdx == -1) {
                zigsIdx = 1;
                dir = 1;
            }
            else if(zigsIdx == numRows) {
                zigsIdx = numRows -2;
                dir = -1;
            }
            
            sIdx++;
        }
        
        String ans = "";
        for(String zig : zigs)
            ans += zig;
        
        return ans;
    }
}