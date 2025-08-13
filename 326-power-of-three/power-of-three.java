class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        for(int i=0;i<=n/3;i++){
            long val = (long)(Math.pow(3,i));
            if(val==n){
                return true;
            }
            if(val>n){
                return false;
            }
        }
        return false;
    }
}