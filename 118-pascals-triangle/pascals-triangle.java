class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(rows(i));
        }
        return ans;
    }
    public List<Integer> rows(int n){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add((int)ans);
        for(int i =1;i<n;i++){
            ans = ans*(n-i);
            ans = ans/i;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}