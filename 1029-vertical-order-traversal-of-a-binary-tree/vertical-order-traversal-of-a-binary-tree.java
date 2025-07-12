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
 class Tuple{
    TreeNode root;
    int row;
    int col;
    public Tuple(TreeNode _root,int _row,int _col){
        this.root = _root;
        this.row = _row;
        this.col = _col;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.root;
            int row = tuple.row;
            int col = tuple.col;
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left,row+1,col-1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,row+1,col+1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> map2 : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> queue : map2.values()){
                while(!queue.isEmpty()){
                    list.add(queue.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}