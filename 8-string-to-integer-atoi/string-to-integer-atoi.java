class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        long n = 0;
        int sign = 1;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                n=n*10+Integer.valueOf(s.charAt(i)-'0');
                if((n*sign)>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if((n*sign)<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            else if(i==0 && s.charAt(i)=='-'){
                sign = -1;
            }
            else if(i==0 && s.charAt(i)=='+'){
                sign = 1;
            }
            else{
                break;
            }
        }
        
        return (int)n*sign;
    }
}