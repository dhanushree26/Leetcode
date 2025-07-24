class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int cnt = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    cnt++;
                    dfs(grid,vis,i,j);   
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid, boolean[][] vis,int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m){
            return;
        }
        if(grid[i][j]=='0' || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        dfs(grid,vis,i+1,j);
        dfs(grid,vis,i-1,j);
        dfs(grid,vis,i,j+1);
        dfs(grid,vis,i,j-1);
    }
}