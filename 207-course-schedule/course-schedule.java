class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = prerequisites.length;
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[numCourses];
        int pathvis[] = new int[numCourses];
        for(int i=0;i<adj.size();i++){
            if(!vis[i]){
                if(dfs(i,vis,pathvis,adj)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int curr,boolean[] vis,int[] pathvis, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        pathvis[curr] = 1;
        for(int i:adj.get(curr)){
            if(!vis[i]){
                if(dfs(i,vis,pathvis,adj)){
                    return true;
                }
            }
            else if(pathvis[i]==1){
                return true;
            }
        }
        pathvis[curr] = 0;
        return false;
    }
}