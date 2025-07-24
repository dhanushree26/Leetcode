class Solution {
    int max = 0;
    int cnt = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //int cnt = 0;
                if(grid[i][j]==1 && !vis[i][j]){
                    cnt = 0;
                    dfs(grid,vis,i,j);
                    max = Math.max(cnt,max);
                }
            }
        }
        return max;
    }
    public void dfs(int[][] grid,boolean[][] vis,int i,int j){
        int n =grid.length;
        int m =grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m){
            return;
        }
        if((grid[i][j]==0) || (vis[i][j])){
            return;
        }
        vis[i][j] = true;
        cnt=cnt+1;
        //max = Math.max(cnt,max);
        dfs(grid,vis,i+1,j);
        dfs(grid,vis,i-1,j);
        dfs(grid,vis,i,j+1);
        dfs(grid,vis,i,j-1);
    }
}