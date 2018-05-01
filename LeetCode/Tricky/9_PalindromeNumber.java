class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0)
            return false;
        
        int rev = 0;
        int tx = x;
        
        while(tx != 0) {
            int rem = tx%10;
            rev = rev*10 + rem;
            tx /= 10;
        }
        
        return rev == x;
        
    }
}