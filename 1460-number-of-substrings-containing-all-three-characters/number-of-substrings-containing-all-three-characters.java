class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int[] hash = {-1,-1,-1};
        int n = s.length();
        int l = 0;
        int r=0;
        while(r<n){
            hash[s.charAt(r)-'a'] = r;
            int min = n;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1){
                for(int i=0;i<3;i++){
                    min = Math.min(min,hash[i]);
                }
                cnt+=(min+1);
            }
            r++;
        }
        return cnt;
    }
}