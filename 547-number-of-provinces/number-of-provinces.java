class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int E = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<E;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[V];
        //ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj);
            }
        }
    }
}