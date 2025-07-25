class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' && !vis[i][j]){
                    cnt++;
                    dfs(board,vis,i,j);
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] board,boolean[][] vis,int i,int j){
        int n = board.length;
        int m = board[0].length;
        if(i<0 || i>=n || j<0 ||j>=m){
            return;
        }
        if(board[i][j]=='.'||vis[i][j]){
            return;
        }
        vis[i][j] = true;
        dfs(board,vis,i+1,j);
        dfs(board,vis,i-1,j);
        dfs(board,vis,i,j+1);
        dfs(board,vis,i,j-1);
    }
}