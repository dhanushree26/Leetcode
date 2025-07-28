class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n,0,0,list,"",0);
        return list;
    }
    public static void helper(int n,int open,int close,List<String>list,String s,int cnt){
        if(cnt==n*2){
            list.add(s);
            return;
        }
        if(open<n){
            helper(n,open+1,close,list,s+"(",cnt+1);
        }
        if(close<open){
            helper(n,open,close+1,list,s+")",cnt+1);
        }
    }
}