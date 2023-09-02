/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = -1001;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }
    
    public int dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            if(root.val > result) {
                result = root.val;
            }
            return root.val;
        } else if(root.left == null) {
            int maxRight = dfs(root.right);
            int curr = Math.max(root.val, root.val + maxRight); 
            if(curr > result) {
                result = curr;
            }
            return curr;
        } else if(root.right == null) {
            int maxLeft = dfs(root.left);
            int curr = Math.max(root.val, root.val + maxLeft); 
            if(curr > result) {
                result = curr;
            }
            return curr;
        } else {
            int maxLeft = dfs(root.left);
            int maxRight = dfs(root.right);
            int curr = Math.max(Math.max(root.val, root.val + maxLeft), root.val + maxRight);
            int currMax = Math.max(curr, root.val + maxLeft + maxRight);
            if(currMax > result) {
                result = currMax;
            }
            return curr;
        }
    }
}