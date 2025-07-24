class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int val = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    val = dfs(grid,vis,i,j);
                }
            }
        }
        return val;
    }
    public int dfs(int[][] grid,boolean[][] vis,int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m){
            return 1;
        }
        if(grid[i][j]==0){
            return 1;
        }
        if(vis[i][j]){
            return 0;
        }
        vis[i][j] = true;
        return dfs(grid,vis,i+1,j)+dfs(grid,vis,i-1,j)+dfs(grid,vis,i,j+1)+dfs(grid,vis,i,j-1);
    }
}