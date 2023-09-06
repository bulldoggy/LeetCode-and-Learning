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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {       
        if(p.val < q.val) {
            return lca(root, p.val, q.val);
        } else {
            return lca(root, q.val, p.val);
        }
    }
    
    private TreeNode lca(TreeNode root, int p, int q) {
        if(p <= root.val && root.val <= q) {
            return root;
        }
        
        if(root.val < p) {
            return lca(root.right, p, q);
        } else {
            return lca(root.left, p, q);
        }
    }
}