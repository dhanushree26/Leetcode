class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        return helper(0,nums,1,1,target);
    }
    public boolean helper(int i,int[] nums,long a,long b,long target){
        if(a>target || b>target){
            return false;
        }
        if(i==nums.length){
            return a==target && b==target;
        }
        boolean check1 = helper(i+1,nums,a*nums[i],b,target);
        boolean check2 = helper(i+1,nums,a,b*nums[i],target);
        return check1 || check2;
    }
}