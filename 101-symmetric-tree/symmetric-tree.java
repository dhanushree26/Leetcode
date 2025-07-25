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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left , root.right);
    }
    public boolean helper(TreeNode node1, TreeNode node2){
        if(node1==null || node2==null){
            return node1==node2;
        }
        if(node1.val!=node2.val){
            return false;
        }
        boolean left = helper(node1.left , node2.right);
        boolean right = helper(node1.right,node2.left);
        if(left && right){
            return true;
        }
        else return false;
    }
}