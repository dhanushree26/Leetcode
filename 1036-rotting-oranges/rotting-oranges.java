class Pair{
    int r;
    int c;
    int t;
    Pair(int r,int c,int t){
        this.r = r;
        this.c = c;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int freshcnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }
        int[] drow ={-1,0,1,0};
        int[] dcol ={0,1,0,-1};
        int cnt = 0;
        int tm = 0;
        while(!q.isEmpty()){
            int row = q.peek().r;
            int col = q.peek().c;
            int t = q.peek().t;
            tm = Math.max(t,tm);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,tm+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt!=freshcnt){
            return -1;
        }
        return tm;
    }
}