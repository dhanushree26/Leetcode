class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer lower = set.floor(nums[i]);
            if(lower!=null && nums[i]-lower <= valueDiff){
                return true;
            }
            Integer upper = set.ceiling(nums[i]);
            if(upper!=null && upper-nums[i]<=valueDiff){
                return true;
            }
            set.add(nums[i]);
            if(i>=indexDiff){
                set.remove(nums[i-indexDiff]);
            }
        }
        return false;
    } 
}