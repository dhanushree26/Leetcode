class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //boolean[][] vis = new boolean[n][m];
        int max = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    dfs(grid,i,j,2);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
                if(grid[i][j]>max){
                    max = grid[i][j];
                }
            }
        }
        return max-2;
    }
    public void dfs(int[][] grid,int i,int j,int cnt){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m){
            return;
        }
        if(grid[i][j]!=1 && grid[i][j]<cnt){
            return;
        }
        grid[i][j] = cnt;
        //vis[i][j] = true;
        dfs(grid,i+1,j,cnt+1);
        dfs(grid,i-1,j,cnt+1);
        dfs(grid,i,j+1,cnt+1);
        dfs(grid,i,j-1,cnt+1);
    }
}