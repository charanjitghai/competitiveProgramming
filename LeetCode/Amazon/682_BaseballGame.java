class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String op : ops){
            
            if("C".equals(op)) {
                stack.pop();
            }
            else if("D".equals(op)) {
                int lastValidRoundScore = stack.peek();
                stack.push(2*lastValidRoundScore);
            }
            else if("+".equals(op)) {
                int lastValidRoundScore = stack.pop();
                int secondLastValidRoundScore = stack.peek();
                stack.push(lastValidRoundScore);
                stack.push(lastValidRoundScore + secondLastValidRoundScore);
            }
            else{
                stack.push(Integer.parseInt(op));
            }
        }
        
        long ans = 0;
        while(! stack.isEmpty()){
            ans += stack.pop();
        }
        return (int) ans;
    }
}