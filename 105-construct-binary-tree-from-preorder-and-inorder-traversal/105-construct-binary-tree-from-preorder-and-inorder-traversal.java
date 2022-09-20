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
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        if(preorder.length == 0 || inorder.length == 0) return null; 
         
        TreeNode treenode = new TreeNode(preorder[0]); 
        int mid = 0; 
        int i = 0; 
        while(mid == 0 && i < inorder.length) { 
            if(preorder[0] == inorder[i]) mid = i; 
            i++; 
        } 
         
        treenode.left = buildTree( 
            Arrays.copyOfRange(preorder, 1, mid+1), 
            Arrays.copyOfRange(inorder, 0, mid)); 
        treenode.right = buildTree( 
            Arrays.copyOfRange(preorder, mid+1, preorder.length), 
            Arrays.copyOfRange(inorder, mid+1, inorder.length)); 
         
        return treenode; 
    } 
}