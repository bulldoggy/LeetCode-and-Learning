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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 0 || postorder.length == 0) {
            return null;
        }
        
        if(preorder.length == 1 || postorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        
        TreeNode tn = new TreeNode(preorder[0]);
        
        int leftPos = 0;
        while(preorder[1] != postorder[leftPos]) {
            leftPos++;
        }
        
        tn.left = constructFromPrePost(
            Arrays.copyOfRange(preorder, 1, 2 + leftPos),
            Arrays.copyOfRange(postorder, 0, 1 + leftPos)
        );
        
        tn.right = constructFromPrePost(
            Arrays.copyOfRange(preorder, 2 + leftPos, preorder.length),
            Arrays.copyOfRange(postorder, 1 + leftPos, postorder.length - 1)
        );
        
        return tn;
    }
}