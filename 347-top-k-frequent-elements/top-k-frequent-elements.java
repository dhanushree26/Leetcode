class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] ans = new int[k];
        int idx = 0;
        while(k>0){
            int max = 0;
            int val = 0;
            for(int i:map.keySet()){
                if(map.get(i)>max){
                    max = map.get(i);
                    val = i;
                }
            }
            ans[idx++] = val;
            map.remove(val);
            k--;
        }
        return ans;
    }
}