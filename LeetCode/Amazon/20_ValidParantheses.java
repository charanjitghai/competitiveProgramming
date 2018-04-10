class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character> ();
        
        for(int i = 0; i<s.length() ; i++) {
            
            char c = s.charAt(i);
            switch(c) {
                    
                case '(' :
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || (! ((Character)'(').equals( stack.peek() ) ) )
                        return false;
                    stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty() || (! ((Character)'{').equals( stack.peek() ) ) )
                        return false;
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || (! ((Character)'[').equals( stack.peek() ) ) )
                        return false;
                    stack.pop();
                    break;
                default:
                    return false;
            }
            
        }
        
        return stack.isEmpty();
    }
}