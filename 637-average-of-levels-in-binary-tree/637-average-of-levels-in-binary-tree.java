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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        double sum = 0;
        
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode treenode = queue.remove();
                sum += treenode.val;
                if(treenode.left != null) queue.add(treenode.left);
                if(treenode.right != null) queue.add(treenode.right);
            }
            System.out.println("sum: " + sum + ", queueSize: " + queueSize);
            result.add(sum/queueSize);
            sum = 0;
        }
        return result;
    }
}