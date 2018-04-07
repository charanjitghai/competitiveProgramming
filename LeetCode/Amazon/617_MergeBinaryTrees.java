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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        
        TreeNode leftMerged = mergeTrees(t1.left, t2.left);
        TreeNode rightMerged = mergeTrees(t1.right, t2.right);
        
        t1.val += t2.val;
        t1.left = leftMerged;
        t1.right = rightMerged;
        
        return t1;
    }
}