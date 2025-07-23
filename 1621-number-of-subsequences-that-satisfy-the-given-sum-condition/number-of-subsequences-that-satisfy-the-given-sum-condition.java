class Solution {
    //int sum = 0;
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        int n=nums.length;
        int l=0;
        int r=n-1;
        int[] pow = new int[n];
        pow[0] = 1;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }
        int cnt = 0;
        while(l<=r){
            if((nums[l]+nums[r]) <= target){
                cnt = (cnt+pow[r-l])%mod;
                l++;
            }
            else r--;
        }
        return cnt;
    }
}