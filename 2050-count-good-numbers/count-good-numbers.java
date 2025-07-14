class Solution {
    private static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evencnt = (n+1)/2;
        long oddcnt = n/2;
        long evenways = helper(5,evencnt,1);
        long oddways = helper(4,oddcnt,1);
        return (int)((evenways*oddways)%MOD);
    }
    public long helper(long x,long n,long ans){
        if(n==0){
            return ans;
        }
        if(n%2==1){
            ans = (ans*x )% MOD;
            return helper(x,n-1,ans);
        }
        else{
            return helper((x*x)%MOD,n/2,ans);
        }
    }
}