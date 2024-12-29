class Solution {
    public void dfs(int row,int col, char[][] board , int[][] vis,int delrow[],int delcol[]){
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<4;i++){
            int nrow = delrow[i]+row;
            int ncol = delcol[i]+col;
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,vis,delrow,delcol);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        int vis[][] = new int[n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]==0){
                dfs(0,i,board,vis,delrow,delcol);
            }
            if(board[n-1][i]=='O' && vis[n-1][i]==0){
                dfs(n-1,i,board,vis,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(i,0,board,vis,delrow,delcol);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(i,m-1,board,vis,delrow,delcol);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}