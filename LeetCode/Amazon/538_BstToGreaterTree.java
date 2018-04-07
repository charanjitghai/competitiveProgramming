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
    public TreeNode convertBST(TreeNode root) {
        sumAllGreater(0, root);
        return root;
    }
    
    private int sumAllGreater(int sum, TreeNode root) {
        
        if(root == null)
            return sum;
        
        int greaterSum = sumAllGreater(sum, root.right);
        root.val += greaterSum;
        return sumAllGreater(root.val, root.left);
        
    }
}