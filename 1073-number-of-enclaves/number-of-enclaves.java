class Solution {
    class Pair{
        int rows;
        int cols;
        public Pair(int row , int col){
            this.rows = row;
            this.cols = col;
        }
    }
    
    public void bfs(int row , int col , int[][] grid,int[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        vis[row][col] = 1;
        while(!q.isEmpty()){
            int rows = q.peek().rows;
            int cols = q.peek().cols;
            q.remove();
            
            for(int i=0;i<4;i++){
                int nrow = rows + delrow[i];
                int ncol = cols + delcol[i];
                if(nrow >=0 && nrow<n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cnt=0;
        
        for(int i=0;i<m;i++){
            if(grid[0][i] == 1 && vis[0][i] == 0){
                bfs(0,i,grid,vis);
            }
            if(grid[n-1][i] == 1 && vis[n-1][i] == 0){
                bfs(n-1,i,grid,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][0] == 1 && vis[i][0] == 0){
                bfs(i,0,grid,vis);
            }
            if(grid[i][m-1] == 1 && vis[i][m-1] == 0){
                bfs(i,m-1,grid,vis);
            }
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}