class Pair{
    int r;
    int c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    cnt++;
                    bfs(grid,vis,i,j);   
                }
            }
        }
        return cnt;
    }
    public void bfs(char[][] grid, boolean[][] vis,int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            int row = q.peek().r;
            int col = q.peek().c;
            q.remove();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int k=0;k<4;k++){
                int nrow = drow[k]+row;
                int ncol = dcol[k]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && !vis[nrow][ncol]){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=true;
                }
            }
        }
    }
}