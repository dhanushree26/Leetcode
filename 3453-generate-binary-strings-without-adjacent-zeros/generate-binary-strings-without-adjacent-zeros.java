class Solution {
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        helper(n,"",'\0',list);
        return list;
    }
    public void helper(int n,String s,char prev,List<String> list){
        if(n==0){
            list.add(s);
            return;
        }
        if(prev != '0'){
            helper(n-1,s+"0",'0',list);
        }
        helper(n-1,s+"1",'1',list);
    } 
}