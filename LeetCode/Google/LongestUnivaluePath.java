/**
* author: charanjitghai
* question: https://leetcode.com/explore/interview/card/google/67/sql-2/473/
*/


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
    Set<TreeNode> visited = new HashSet<>();

    int[] dfs (TreeNode node, int val) {
        if(node == null)
            return new int[] {0,0};
        if(node.left == null && node.right == null) {
            if(node.val == val)
                return new int[] {1,1};
            return new int[] {1,0};
        }

        if(node.val == val) {
            int[] left = dfs(node.left, val);
            int[] right = dfs(node.right, val);
            int maxD = Math.max(left[1], right[1]) + 1;
            int vMax = left[1] + right[1] + 1;
            int tMax = Math.max(Math.max(left[0], right[0]), vMax);
            return new int[] {tMax, maxD};
        }
        else {
            int[] left = dfs(node.left, node.val);
            int[] right = dfs(node.right, node.val);
            int vMax = left[1] + right[1] + 1;
            int tMax = Math.max(Math.max(left[0], right[0]), vMax);
            return new int[] {tMax, 0};
        }
    }

    public int longestUnivaluePath(TreeNode root) {
        int ans = dfs(root, -18493849)[0] -1;
        if(ans < 0)
            return 0;
        return ans;
    }
}
