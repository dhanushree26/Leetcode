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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wraplist = new ArrayList<>();
        if(root==null){
            return wraplist;
        }
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node = queue.poll();
                if(flag){
                    list.add(node.val);
                }
                else{
                    list.add(0,node.val);
                }
                if(node.left != null){ 
                    queue.offer(node.left);
                }
                if(node.right != null){ 
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            wraplist.add(list);
        }
        return wraplist;
    }
}