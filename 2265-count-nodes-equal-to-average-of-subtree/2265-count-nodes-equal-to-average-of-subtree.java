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
    int result = 0;
    
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private Pair dfs(TreeNode node) {
        if(node == null) {
            return new Pair(0, 0);
        }
        
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        int totalSum = left.sum + right.sum + node.val;
        int totalCount = left.count + right.count + 1;
        int average = 0;
                
        if(totalCount != 0) {
            average = totalSum / totalCount; 
            if(node.val == average) {
                result++;
            }
        } else {
            result++;
        }
        
        
        return new Pair(totalSum, totalCount);
    }
}

class Pair {
    int sum;
    int count;
    
    public Pair(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}