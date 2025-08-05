class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int len = trust.length;
        for(int[] i:trust){
            int a = i[0];
            int b = i[1];
            list.get(a).add(b);
        }
        for(int i=1;i<=n;i++){
            boolean flag = true;
            if(list.get(i).size()!=0) continue;
            for(int j=1;j<=n;j++){
                if(i==j){
                    continue;
                }
                flag = list.get(j).contains(i);
                if(!flag){
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}