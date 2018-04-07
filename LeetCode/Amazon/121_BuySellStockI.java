class Solution {
    public int maxProfit(int[] prices) {
       
        int max = 0;
        int maxProfit = 0;
        
        for(int i = prices.length -1; i >= 0 ; i--) {
            
            int curProfit = max - prices[i];
            
            if(curProfit > maxProfit)
                maxProfit = curProfit;
            
            max = Math.max(max, prices[i]);
            
        }
        
        return maxProfit;
    }
}