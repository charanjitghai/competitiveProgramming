/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private void appendLeftChildStr(StringBuilder parent, String child){
        
        parent.append("(");
        parent.append(child);
        parent.append(")");
    }
    
    private void appendRightChildStr(StringBuilder parent, String child){
        if(! child.equals("")){
            parent.append("(");
            parent.append(child);
            parent.append(")");
        }
    }
    
    public String tree2str(TreeNode t){
        
        if(t == null)
            return "";
        
        if(t.left == null && t.right == null)
            return Integer.toString(t.val);
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        
        appendLeftChildStr(sb, tree2str(t.left));
        appendRightChildStr(sb, tree2str(t.right));
        
        return sb.toString();
    }
}