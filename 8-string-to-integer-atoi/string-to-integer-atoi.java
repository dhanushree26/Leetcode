class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty()){
            return 0;
        }
        int sign = 1;
        int idx = 0;
        if(s.charAt(idx)=='-'){
            sign = -1;
            idx++;
        }
        else if(s.charAt(idx)=='+'){
            idx++;
        }
        return helper(s,idx,0,sign);
    }
    public int helper(String s,int idx,int res,int sign){
        if(idx>=s.length() ||!Character.isDigit(s.charAt(idx))){
            return sign*res;
        }
        int dig = s.charAt(idx)-'0';
        if(sign==1 && res > (Integer.MAX_VALUE-dig)/10){
            return Integer.MAX_VALUE;
        }
        if(sign==-1 && res > (Integer.MAX_VALUE-dig)/10){
            return Integer.MIN_VALUE;
        }
        return helper(s,idx+1,res*10+dig,sign);
    }
}