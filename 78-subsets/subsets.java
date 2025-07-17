class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,nums,new ArrayList<>(),res);
        return res;
    }
    public void helper(int idx,int[] nums,List<Integer> list,List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int i=idx;i<nums.length;i++){
            list.add(nums[i]);
            helper(i+1,nums,list,res);
            list.remove(list.size()-1);
        }
    }
}