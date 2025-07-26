class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int len = trust.length;
        for(int i=0;i<len;i++){
            int a = trust[i][0];
            int b = trust[i][1];
            list.get(a-1).add(b-1);
        }
        for(int i=0;i<n;i++){
            boolean flag = true;
            if(list.get(i).size()!=0) continue;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                flag = list.get(j).contains(i);
                if(!flag){
                    break;
                }
            }
            if(flag){
                return i+1;
            }
        }
        return -1;
    }
}